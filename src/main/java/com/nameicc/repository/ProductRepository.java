package com.nameicc.repository;

import com.nameicc.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> queryBySkus(List<String> skus);

}
