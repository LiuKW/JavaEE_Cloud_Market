package com.vvlhw.supermarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vvlhw.supermarket.handler.MyLocalDateTimeTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="用户表")
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户ID号")
    @TableId(value = "user_id", type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    @ApiModelProperty(value = "昵称")
    @NotBlank
    private String userNickname;

    @ApiModelProperty(value = "头像链接")
    @TableField("user_avatarUrl")
    private String userAvatarurl;

    @ApiModelProperty(value = "手机号做用户名")
    @NotBlank
    private String userPhone;

    @ApiModelProperty(value = "MD5加密后的密码")
    @Length(min = 8, max = 16, message = "密码长度应在：8 ~ 16 之间")
    private String userPassword;

    @ApiModelProperty(value = "加盐")
    private String userSalt;

    @ApiModelProperty(value = "用户创建时间")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "用户修改时间")
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "0不删除1删除")
    @TableField("loginDelete")
    @TableLogic
    private Integer loginDelete;


}
