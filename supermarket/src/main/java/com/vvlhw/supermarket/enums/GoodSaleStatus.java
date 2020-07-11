package com.vvlhw.supermarket.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodSaleStatus {

    NEW(0, "新建"),
    ONSALE(1, "上架"),
    OFFSALE(2, "下架"),
    ;

    private Integer code;

    private String message;


}
