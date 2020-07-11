package com.vvlhw.supermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goodtt {
    private Long goodId;
    private int count;
    private BigDecimal price;
}
