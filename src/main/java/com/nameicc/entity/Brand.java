package com.nameicc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("brands")
public class Brand implements Serializable {

    private Integer id;

    @TableField("brandName")
    private String brandName;

    @TableField("brandCode")
    private String brandCode;

}
