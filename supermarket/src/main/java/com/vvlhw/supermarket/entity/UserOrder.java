package com.vvlhw.supermarket.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vvlhw.supermarket.utils.KeyUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("userOrder")
@ApiModel(value="UserOrder对象", description="订单表")
@Accessors(chain = true)
public class UserOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单ID号")
    @TableId(value = "order_id", type = IdType.INPUT)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId = KeyUtil.getKey();

    @ApiModelProperty(value = "用户ID号")
    private Long userId;

    @ApiModelProperty(value = "每项是商品ID+当时单价+数量")
    private String orderContent;

    @ApiModelProperty(value = "订单价格")
    private BigDecimal orderPrice;

    @ApiModelProperty(value = "订单地址")
    private String orderAddress;

    @ApiModelProperty(value = "0取消1支付2待支付")
    private Integer orderStatus;

    @ApiModelProperty(value = "支付流水号")
    @TableField("pay_serial_num")
    private Long paySerialNum;

    @ApiModelProperty(value = "订单创建时间")
    @TableField(value = "order_time", fill = FieldFill.INSERT)
    private LocalDateTime orderTime;

    @ApiModelProperty(value = "0不删除1删除")
    @TableField("loginDelete")
    @TableLogic
    private Integer loginDelete;


}
