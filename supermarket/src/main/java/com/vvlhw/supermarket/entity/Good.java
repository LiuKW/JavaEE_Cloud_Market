package com.vvlhw.supermarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
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
 * 商品表
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Good对象", description="商品表")
@Accessors(chain = true)
public class Good implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品ID号")
    @TableId(value = "good_id", type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodId;

    @ApiModelProperty(value = "商品名称")
    @NotBlank(message = "商品名称不能为空")
    private String goodName;

    @ApiModelProperty(value = "商品描述")
    @NotBlank(message = "商品描述不能为空")
    private String goodDescription;

    @ApiModelProperty(value = "商品拥有者")
    private String goodOwner;

    @ApiModelProperty(value = "所属分类ID号")
    @NotNull(message = "商品分类不能为空")
    private Long catId;

    @ApiModelProperty(value = "商品价格")
    @NotNull(message = "商品价格不能为空")
    private BigDecimal goodPrice;

    @ApiModelProperty(value = "商品销量")
    private Integer goodSale;

    @ApiModelProperty(value = "商品主图片")
    @TableField("good_mainImageUrl")
    private String goodMainimageurl;

    @ApiModelProperty(value = "商品链接（待定、下什么）")
    private String goodAddress;

    @ApiModelProperty(value = "0不推荐1推荐")
    @TableField("good_isRecommend")
    private Integer goodIsrecommend;

    @ApiModelProperty(value = "0新建1上架2下架")
    @TableField("good_onSale")
    private Integer goodOnsale;

    @ApiModelProperty(value = "商品创建时间")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "商品修改时间")
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
