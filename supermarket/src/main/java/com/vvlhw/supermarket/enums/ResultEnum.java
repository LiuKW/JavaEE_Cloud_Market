package com.vvlhw.supermarket.enums;

import lombok.Getter;

@Getter
public enum ResultEnum implements CodeEnum {
    SUCCESS(10000, "操作成功"),
    FAIL(10002, "操作失败"),
    UNAUTHORIZED(20000, "未登录"),
    FORBIDDEN(20001, "凭证无效"),
    USER_NOT_FOUND(20002, "用户不存在"),
    ALREADY_REGISTER(20003, "该账户已注册"),
    PARAM_ERROR(20004, "参数错误"),
    CODE_ERROR(20005, "验证码错误"),
    CODE_ALREADY_EXIST(20006, "验证码已存在，请勿重复发送"),
    CODE_NOT_EXIST(20007, "验证码不存在"),
    SEND_CODE_FAIL(20008, "发送短信验证码失败"),
    PASSWORD_ERROR(20009, "密码错误")
    ;

    private Integer code;
    private String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
