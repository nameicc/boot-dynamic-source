package com.nameicc.service;

import com.nameicc.request.AddProductTagParam;
import com.nameicc.vo.ProductVo;

import java.util.List;

public interface ProductService {

    List<ProductVo> queryBySkus(List<String> skus);

    boolean addProductTag(AddProductTagParam param);

}
