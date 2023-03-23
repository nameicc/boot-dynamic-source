package com.nameicc.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nameicc.entity.Brand;
import com.nameicc.mapper.BrandMapper;
import com.nameicc.repository.BrandRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BrandRepositoryImpl implements BrandRepository {

    @Resource
    private BrandMapper brandMapper;

    @DS("shop_slave")
    @Override
    public List<Brand> queryByIds(List<Integer> brandIds) {
        LambdaQueryWrapper<Brand> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Brand::getId, brandIds);
        return brandMapper.selectList(wrapper);
    }
}
