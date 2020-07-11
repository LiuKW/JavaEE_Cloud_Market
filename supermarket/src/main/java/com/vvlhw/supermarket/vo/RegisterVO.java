package com.vvlhw.supermarket.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterVO {
    private Long userId;
    @NotBlank(message = "昵称不能为空")
    private String userNickname;

    @NotBlank(message = "手机号码不能为空")
    private String userPhone;

    @Length(min = 8, max = 16, message = "密码长度应在：8 ~ 16 之间")
    private String userPassword;

//    @NotBlank(message = "短信验证码不能为空")
//    private String code;
}
