package com.nameicc.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nameicc.entity.ProductType;
import com.nameicc.mapper.ProductTypeMapper;
import com.nameicc.repository.ProductTypeRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProductTypeRepositoryImpl implements ProductTypeRepository {

    @Resource
    private ProductTypeMapper productTypeMapper;

    @DS("shop_slave")
    @Override
    public List<ProductType> queryByIds(List<Integer> typeIds) {
        LambdaQueryWrapper<ProductType> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(ProductType::getId, typeIds);
        return productTypeMapper.selectList(wrapper);
    }

}
