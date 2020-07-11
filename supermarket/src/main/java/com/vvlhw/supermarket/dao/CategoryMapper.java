package com.vvlhw.supermarket.dao;

import com.vvlhw.supermarket.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vvlhw.supermarket.vo.CategoryVO;

/**
 * <p>
 * 分类表 Mapper 接口
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
public interface CategoryMapper extends BaseMapper<Category> {
    CategoryVO findGoodPageByCatId(Long catId);
}
