package com.vvlhw.supermarket.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum implements CodeEnum {

    CANCEL(0, "订单取消"),
    SUCCESS(1,"支付成功"),
    WAIT_FOR_PAY(2,"待支付")
    ;

    private Integer code;

    private String message;


}
