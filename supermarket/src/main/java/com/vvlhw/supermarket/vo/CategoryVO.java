package com.vvlhw.supermarket.vo;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vvlhw.supermarket.entity.Good;
import lombok.Data;

import java.util.List;

/**
 * 分类查询一个分类下的所有商品
 */
@Data
public class CategoryVO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long catId;
    private String catName;
    private Integer catGoodCount;
    List<Good> goods;
}
