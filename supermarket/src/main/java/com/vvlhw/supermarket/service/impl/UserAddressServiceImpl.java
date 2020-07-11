package com.vvlhw.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vvlhw.supermarket.entity.UserAddress;
import com.vvlhw.supermarket.dao.UserAddressMapper;
import com.vvlhw.supermarket.service.UserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户地址关系表 服务实现类
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

    // 添加地址
    public void insertAddress(UserAddress userAddress)
    {
        save(userAddress);
    }

    // 查询地址
    public List<UserAddress> findUserAddress(Long userId)
    {
        Map<String , Object> map = new HashMap<>();
        map.put("user_id", userId);
        return this.baseMapper.selectByMap(map);
    }

    // 删除地址
    public void deleteUserAddress(Long id)
    {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("address_id", id);
        this.baseMapper.delete(wrapper);
    }


    // 修改地址
    public void updateUserAddress(UserAddress userAddress)
    {
        this.baseMapper.updateById(userAddress);
    }


}
