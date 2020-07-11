package com.vvlhw.supermarket.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodRecommendEnum {
    NOT_RECOMMEND(0, "不推荐"),
    RECOMMEND(1, "推荐"),
    ;

    private Integer code;

    private String message;
}
