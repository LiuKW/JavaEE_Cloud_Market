package com.vvlhw.supermarket.service.impl;

import com.vvlhw.supermarket.entity.Category;
import com.vvlhw.supermarket.dao.CategoryMapper;
import com.vvlhw.supermarket.entity.Good;
import com.vvlhw.supermarket.entity.UserAddress;
import com.vvlhw.supermarket.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vvlhw.supermarket.vo.CategoryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    public CategoryVO findGoodsByCateId(Long catId)
    {
        return this.baseMapper.findGoodPageByCatId(catId);
    }
}
