package com.nameicc.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductVo implements Serializable {

    private Integer productId;

    private String sku;

    private String productFullName;

    private Integer brandId;

    private String brandName;

    private Integer productTypeId;

    private String productTypeName;

    private List<Integer> tagIds;

}
