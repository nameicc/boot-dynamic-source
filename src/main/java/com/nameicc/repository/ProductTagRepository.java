package com.nameicc.repository;

import com.nameicc.entity.ProductTag;

import java.util.List;

public interface ProductTagRepository {

    List<ProductTag> queryBySkus(List<String> skus);

    void insert(ProductTag entity);

}
