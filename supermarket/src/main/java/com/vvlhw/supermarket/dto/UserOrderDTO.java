package com.vvlhw.supermarket.dto;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserOrderDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    Long userId;
    @JsonSerialize(using = ToStringSerializer.class)
    Long orderId;
    BigDecimal totalPrice;
    String orderAddress;
    JSONArray goodsList;
}