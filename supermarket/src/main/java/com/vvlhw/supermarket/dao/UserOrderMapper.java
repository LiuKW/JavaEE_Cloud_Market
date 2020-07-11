package com.vvlhw.supermarket.dao;

import com.vvlhw.supermarket.entity.UserOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Repository
public interface UserOrderMapper extends BaseMapper<UserOrder> {

//    default List<UserOrder> findOrdersByUserId(Long id)
//    {
//        Map<String, Object> map = new HashMap<>();
//        map.put("user_id", id);
//        return this.selectByMap(map);
//    }

    List<UserOrder> findOrdersByUserId(Long id);

}
