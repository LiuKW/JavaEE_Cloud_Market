package com.vvlhw.supermarket.controller;


import com.alibaba.fastjson.JSONObject;
import com.vvlhw.supermarket.entity.UserAddress;
import com.vvlhw.supermarket.service.UserAddressService;
import com.vvlhw.supermarket.service.impl.UserAddressServiceImpl;
import com.vvlhw.supermarket.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 用户地址关系表 前端控制器
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Api(tags = "用户地址模块")
@RestController
@RequestMapping("/supermarket/user-address")
public class UserAddressController {

    @Autowired
    private UserAddressServiceImpl userAddressService;

    // 添加地址
    @ApiOperation("添加地址")
    @PostMapping
    public R addAddress(@Valid @RequestBody UserAddress userAddress) {
        userAddressService.insertAddress(userAddress);
        return R.ok();
    }


    // 查询地址
    @ApiOperation("查询地址，传的是userId")
    @GetMapping("/{userId}")
    public R findUserAddress(@PathVariable("userId") Long id) {
        List<UserAddress> addresses = userAddressService.findUserAddress(id);
        return R.ok().put("address", addresses);
    }

    // 修改地址
    @ApiOperation("修改地址")
    @PutMapping
    public R updateUserAddress(@Valid @RequestBody UserAddress userAddress)
    {
        userAddressService.updateUserAddress(userAddress);
        return R.ok();
    }

    @ApiOperation("删除地址，这里的id是地址的id，注意和查询传递的值不同")
    @DeleteMapping("/{id}")
    public R deleteUserAddress(@PathVariable("id") Long id)
    {
        userAddressService.deleteUserAddress(id);
        return R.ok();
    }


}

