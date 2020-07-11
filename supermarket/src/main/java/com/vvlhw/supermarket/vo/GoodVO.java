package com.vvlhw.supermarket.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vvlhw.supermarket.entity.Good;
import com.vvlhw.supermarket.entity.GoodImages;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 展示给前端的商品图片
 */
@Data
public class GoodVO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodId;
    private String goodName;
    private String goodDescription;
    private String goodOwner;
    private Long catId;
    private BigDecimal goodPrice;
    private Integer goodSale;
    private String mainImageUrl;
    private List<GoodImages> goodImages;

}
