package com.vvlhw.supermarket.controller;



import com.vvlhw.supermarket.dto.OrderDTO;
import com.vvlhw.supermarket.entity.User;
import com.vvlhw.supermarket.service.impl.UserServiceImpl;
import com.vvlhw.supermarket.utils.JwtUtil;
import com.vvlhw.supermarket.utils.R;
import com.vvlhw.supermarket.vo.LoginVO;
import com.vvlhw.supermarket.vo.RegisterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@RestController
@RequestMapping("/supermarket/user")
@Api(tags = "用户模块")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @ApiOperation("发送验证码")
    @GetMapping("/code/{userPhone}")
    public R sendMsg(@PathVariable("userPhone") String userPhone)
    {
        userService.sendMessage(userPhone);
        return R.ok();
    }


    @ApiOperation("检验验证码")
    @PostMapping("/code")
    public R checkCode(@RequestBody Map<String, String> map)
    {
        userService.checkCode(map);
        return R.ok();
    }


    @ApiOperation("用户注册")
    @PutMapping("/register")
    public R register(@Valid @RequestBody RegisterVO registerVO)
    {
        userService.register(registerVO);
        return R.ok();
    }

    @ApiOperation("用户登录")
    @PostMapping(value = "/login")
    public R login(@Valid @RequestBody LoginVO loginVO)
    {
        User user = userService.checkUser(loginVO.getUserPhone(), loginVO.getUserPassword());
        String token = JwtUtil.geneJsonWebToken(user);
        return R.ok().put("token", token).put("user", user);
    }

    @ApiOperation("用户修改个人信息")
    @PutMapping("/update")
    public R update(@Valid @RequestBody User user)
    {
        userService.updateUser(user);
        return R.ok();
    }


    @ApiOperation("查看个人订单记录")
    @GetMapping("/orders/{id}")
    public R orders(@PathVariable("id") Long id)
    {
        OrderDTO orders = userService.findUserOrders(id);
        return R.ok().put("orders", orders);
    }




}
