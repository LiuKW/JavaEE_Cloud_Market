package com.vvlhw.supermarket.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vvlhw.supermarket.utils.KeyUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserOrderVO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId = KeyUtil.getKey();

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String orderContent;

    private BigDecimal orderPrice;

    private String orderAddress;

    private Integer orderStatus;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long paySerialNum;

    private LocalDateTime orderTime;

    private Integer loginDelete;

}
