package com.vvlhw.supermarket.dao;

import com.vvlhw.supermarket.dto.GoodDTO;
import com.vvlhw.supermarket.entity.Good;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Repository
public interface GoodMapper extends BaseMapper<Good> {

    GoodDTO findOneGood(Long goodId);


    /**
     * 用了一下MyBatis的写法，主要想得到新增的【gid】
     * 以便插入图片集用到
     */
    void mySave(Good good);
}
