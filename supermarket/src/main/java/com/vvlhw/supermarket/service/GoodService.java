package com.vvlhw.supermarket.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vvlhw.supermarket.entity.Good;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vvlhw.supermarket.vo.PageVO;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
public interface GoodService extends IService<Good> {

    List<Good> getBycatIdAndOther(Long catId, String other);

    Long mySave(Good good);

}
