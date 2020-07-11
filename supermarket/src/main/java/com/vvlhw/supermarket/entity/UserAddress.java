package com.vvlhw.supermarket.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户地址关系表
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("userAddress")
@ApiModel(value="UserAddress对象", description="用户地址关系表")
@Accessors(chain = true)
public class UserAddress implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "地址ID号")
    @TableId(value = "address_id", type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long addressId;

    @ApiModelProperty(value = "用户ID号")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @ApiModelProperty(value = "地址内容（不细分）")
    @NotBlank(message = "地址不能为空")
    private String addressContent;

    @ApiModelProperty(value = "地址创建时间")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "地址修改时间")
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
