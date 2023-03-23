package com.nameicc.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddProductTagParam implements Serializable {

    private String sku;

    private Integer tagId;

}
