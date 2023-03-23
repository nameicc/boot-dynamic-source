package com.nameicc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("producttypes")
public class ProductType implements Serializable {

    private Integer id;

    @TableField("typeName")
    private String typeName;

}
