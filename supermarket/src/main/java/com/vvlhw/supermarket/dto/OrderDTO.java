package com.vvlhw.supermarket.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vvlhw.supermarket.entity.UserOrder;
import lombok.Data;

import java.util.List;

/**
 * 用于查询用户下的所有订单
 */
@Data
public class OrderDTO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    private String userNickname;
    private String userPhone;
    private List<UserOrder> orders;
}
