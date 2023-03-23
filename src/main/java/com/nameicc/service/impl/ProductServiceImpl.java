package com.nameicc.service.impl;

import com.nameicc.entity.Brand;
import com.nameicc.entity.Product;
import com.nameicc.entity.ProductTag;
import com.nameicc.entity.ProductType;
import com.nameicc.repository.BrandRepository;
import com.nameicc.repository.ProductRepository;
import com.nameicc.repository.ProductTagRepository;
import com.nameicc.repository.ProductTypeRepository;
import com.nameicc.request.AddProductTagParam;
import com.nameicc.service.ProductService;
import com.nameicc.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private BrandRepository brandRepository;

    @Resource
    private ProductTypeRepository productTypeRepository;

    @Resource
    private ProductTagRepository productTagRepository;

    @Override
    public List<ProductVo> queryBySkus(List<String> skus) {
        List<ProductVo> vos = new ArrayList<>();
        // 基础商品查询
        List<Product> products = productRepository.queryBySkus(skus);
        if (CollectionUtils.isEmpty(products)) {
            return vos;
        }
        products.forEach(product -> {
            ProductVo vo = new ProductVo();
            BeanUtils.copyProperties(product, vo);
            vos.add(vo);
        });
        // 填充品牌
        fillBrandName(vos);
        // 填充商品类型
        fillProductType(vos);
        // 填充商品标签
        fillProductTag(vos);
        return vos;
    }

    private void fillBrandName(List<ProductVo> vos) {
        List<Integer> brandIds = vos.stream().map(e -> e.getBrandId()).collect(Collectors.toList());
        List<Brand> brands = brandRepository.queryByIds(brandIds);
        Map<Integer, Brand> brandMap = brands.stream().collect(Collectors.toMap(e -> e.getId(), e -> e, (v1, v2) -> v2));
        vos.forEach(vo -> {
            if (brandMap.containsKey(vo.getBrandId())) {
                Brand brand = brandMap.get(vo.getBrandId());
                vo.setBrandName(brand.getBrandName());
            }
        });
    }

    private void fillProductType(List<ProductVo> vos) {
        List<Integer> productTypeIds = vos.stream().map(e -> e.getProductTypeId()).collect(Collectors.toList());
        List<ProductType> productTypes = productTypeRepository.queryByIds(productTypeIds);
        Map<Integer, ProductType> productTypeMap = productTypes.stream().collect(Collectors.toMap(e -> e.getId(), e -> e, (v1, v2) -> v2));
        vos.forEach(vo -> {
            if (productTypeMap.containsKey(vo.getProductTypeId())) {
                ProductType productType = productTypeMap.get(vo.getProductTypeId());
                vo.setProductTypeName(productType.getTypeName());
            }
        });
    }

    private void fillProductTag(List<ProductVo> vos) {
        List<String> skus = vos.stream().map(e -> e.getSku()).collect(Collectors.toList());
        List<ProductTag> productTags = productTagRepository.queryBySkus(skus);
        Map<String, List<ProductTag>> tagMap = productTags.stream().collect(Collectors.groupingBy(e -> e.getSku()));
        vos.forEach(vo -> {
            if (tagMap.containsKey(vo.getSku())) {
                List<ProductTag> tags = tagMap.get(vo.getSku());
                List<Integer> tagIds = tags.stream().map(e -> e.getTagId()).collect(Collectors.toList());
                vo.setTagIds(tagIds);
            }
        });
    }

    @Override
    public boolean addProductTag(AddProductTagParam param) {
        try {
            ProductTag entity = new ProductTag();
            entity.setProductId(0);
            entity.setSku(param.getSku());
            entity.setTagId(param.getTagId());
            entity.setAddTime((int)(System.currentTimeMillis() / 1000));
            entity.setAddUser("管理员测试");
            productTagRepository.insert(entity);
        } catch (Exception e) {
            log.error("商品标签保存失败", e);
            return false;
        }
        return true;
    }

}
