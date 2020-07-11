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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Category对象", description="分类表")
@Accessors(chain = true)
public class Category implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "分类ID号")
    @TableId(value = "cat_id", type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long catId;

    @ApiModelProperty(value = "分类名称")
    private String catName;

    @ApiModelProperty(value = "该分类的商品数量")
    @TableField("cat_goodCount")
    private Integer catGoodcount;

    @ApiModelProperty(value = "分类创建时间")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "分类修改时间")
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
