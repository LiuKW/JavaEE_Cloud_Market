package com.vvlhw.supermarket.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单orderContent字段中的其中一条记录
 */
@Data
public class SingleGoodDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodId;
    private int count;
    private BigDecimal unitPrice;
}
