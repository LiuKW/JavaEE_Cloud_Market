package com.vvlhw.supermarket.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginVO {
    @NotNull(message = "手机号码（账号），不能为空")
    String userPhone;

    @Length(min = 8, max = 16, message = "密码长度应在：8 ~ 16 之间")
    String userPassword;
}
