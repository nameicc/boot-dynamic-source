package com.nameicc.controller;

import com.nameicc.request.AddProductTagParam;
import com.nameicc.request.QueryProductParam;
import com.nameicc.service.ProductService;
import com.nameicc.vo.ProductVo;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/queryBySkus")
    public List<ProductVo> queryBySkus(@RequestBody QueryProductParam param) {
        if (CollectionUtils.isEmpty(param.getSkus())) {
            return new ArrayList<>();
        }
        return productService.queryBySkus(param.getSkus());
    }

    @PostMapping("/addProductTag")
    public boolean addProductTag(@RequestBody AddProductTagParam param) {
        return productService.addProductTag(param);
    }

}
