package com.nameicc.repository;

import com.nameicc.entity.ProductType;

import java.util.List;

public interface ProductTypeRepository {

    List<ProductType> queryByIds(List<Integer> typeIds);

}
