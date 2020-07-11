package com.vvlhw.supermarket.dto;

import com.vvlhw.supermarket.entity.Goodtt;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderD {
    private Long userId;
    private BigDecimal totalPrice;
    private String orderAddress;
    private List<Goodtt> goodsList;

}
