package com.nameicc.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nameicc.entity.Product;
import com.nameicc.mapper.ProductMapper;
import com.nameicc.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Resource
    private ProductMapper productMapper;

    @DS("store_slave")
    @Override
    public List<Product> queryBySkus(List<String> skus) {
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Product::getSku, skus);
        return productMapper.selectList(wrapper);
    }

}
