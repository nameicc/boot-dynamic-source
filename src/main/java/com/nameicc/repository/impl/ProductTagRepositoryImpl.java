package com.nameicc.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nameicc.entity.ProductTag;
import com.nameicc.mapper.ProductTagMapper;
import com.nameicc.repository.ProductTagRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProductTagRepositoryImpl implements ProductTagRepository {

    @Resource
    private ProductTagMapper productTagMapper;

    @DS("store_slave")
    @Override
    public List<ProductTag> queryBySkus(List<String> skus) {
        LambdaQueryWrapper<ProductTag> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(ProductTag::getSku, skus);
        return productTagMapper.selectList(wrapper);
    }

    @DS("store_master")
    @Override
    public void insert(ProductTag entity) {
        productTagMapper.insert(entity);
    }

}
