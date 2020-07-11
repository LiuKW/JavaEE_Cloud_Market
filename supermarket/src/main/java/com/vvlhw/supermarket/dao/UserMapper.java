package com.vvlhw.supermarket.dao;

import com.vvlhw.supermarket.dto.OrderDTO;
import com.vvlhw.supermarket.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
public interface UserMapper extends BaseMapper<User> {

    OrderDTO findOrderById(Long id);


}
