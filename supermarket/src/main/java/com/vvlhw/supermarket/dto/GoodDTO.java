package com.vvlhw.supermarket.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vvlhw.supermarket.entity.GoodImages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


/**
 * 用于查询一个商品，且带上轮播图
 */
@Data
public class GoodDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodId;
    private String goodName;
    private String goodDescription;
    private String goodOwner;
    private Long catId;
    private BigDecimal goodPrice;
    private Integer goodSale;
    private String goodMainimageUrl;
    private List<GoodImages> goodImages;
}