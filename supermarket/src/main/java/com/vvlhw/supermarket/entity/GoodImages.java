package com.vvlhw.supermarket.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品图片集表
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("goodImages")
@ApiModel(value="GoodImages对象", description="商品图片集表")
@Accessors(chain = true)
public class GoodImages implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品图片ID号")
    @TableId(value = "image_id", type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long imageId;

    @ApiModelProperty(value = "商品ID号")
    private Long goodId;

    @ApiModelProperty(value = "图片名字/内容")
    private String imageDescription;

    @ApiModelProperty(value = "图片链接")
    private String imageUrl;

    @ApiModelProperty(value = "0不删除1删除")
    @TableField("loginDelete")
    @TableLogic
    private Integer loginDelete;


}
