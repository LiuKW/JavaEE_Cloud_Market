package com.vvlhw.supermarket.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车字段
 */
@Data
public class CartDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    private BigDecimal totalPrice;
    private String orderAddress;
    private List<SingleGoodDTO> goodsList;
}
