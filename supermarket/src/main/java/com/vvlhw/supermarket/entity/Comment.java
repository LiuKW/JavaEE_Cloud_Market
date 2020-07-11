package com.vvlhw.supermarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 评论表
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Comment对象", description="评论表")
@Accessors(chain = true)
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "评论ID号")
    @TableId(value = "comment_id", type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long commentId;

    @ApiModelProperty(value = "商品ID号")
    private Long goodId;

    @ApiModelProperty(value = "用户ID号")
    private Long userId;

    @ApiModelProperty(value = "回复/评论的内容")
    private String commentContent;

    @ApiModelProperty(value = "评论的时间")
    @TableField(fill = FieldFill.INSERT)
    private Date commentTime;

    @ApiModelProperty(value = "评论上级ID号")
    private Long commentFather;

    @ApiModelProperty(value = "0不删除1删除")
    @TableField("loginDelete")
    @TableLogic
    private Integer loginDelete;


}
