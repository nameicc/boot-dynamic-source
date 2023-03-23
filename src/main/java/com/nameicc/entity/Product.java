package com.nameicc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("products")
public class Product implements Serializable {

    private Integer productId;

    private String sku;

    private String productFullName;

    private Integer brandId;

    private Integer productTypeId;

}
