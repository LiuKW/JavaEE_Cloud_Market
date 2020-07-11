package com.vvlhw.supermarket.service.user;

import com.vvlhw.supermarket.dto.OrderDTO;
import com.vvlhw.supermarket.entity.User;
import com.vvlhw.supermarket.handler.MyLocalDateTimeTypeHandler;
import com.vvlhw.supermarket.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserServiceImpl userService;



    @Test
    void testLogin()
    {
        String userPhone = "13018612893";
        String userPassword = "123456789";

        User user = userService.checkUser(userPhone, userPassword);
        System.out.println(user);

    }


    @Test
    void testInsert()
    {
        User user = new User();
        user.setUserPhone("13018612893").setUserNickname("Amy").setUserPassword("123456789");
        //userService.register(user);
    }


    @Test
    void testUpdate()
    {
        User user = new User();
        user.setUserId(11L).setUserPhone("789").setUserNickname("Mike");
        userService.getBaseMapper().updateById(user);
    }


    @Test
    void testGetOrders()
    {
        OrderDTO userOrders = userService.findUserOrders(20L);
        userOrders.getOrders().forEach(System.out::println);
    }


}
