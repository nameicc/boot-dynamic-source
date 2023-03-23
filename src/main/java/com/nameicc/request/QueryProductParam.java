package com.nameicc.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryProductParam implements Serializable {

    private List<String> skus;

}
