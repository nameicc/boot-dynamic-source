package com.nameicc.repository;

import com.nameicc.entity.Brand;

import java.util.List;

public interface BrandRepository {

    List<Brand> queryByIds(List<Integer> brandIds);

}
