package com.nameicc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("product_tag_relate")
public class ProductTag implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String sku;

    private Integer tagId;

    private Integer addTime;

    private String addUser;

}
