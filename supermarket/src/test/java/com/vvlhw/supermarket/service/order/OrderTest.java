package com.vvlhw.supermarket.service.order;

import com.alibaba.fastjson.JSONObject;
import com.vvlhw.supermarket.dao.UserOrderMapper;
import com.vvlhw.supermarket.entity.Goodtt;
import com.vvlhw.supermarket.entity.UserOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class OrderTest {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Test
    void testFindOrders()
    {
        System.out.println(userOrderMapper);
        List<UserOrder> orders = userOrderMapper.findOrdersByUserId(20L);
        orders.forEach(System.out::println);
    }


    @Autowired
    DataSource dataSource;
    
    @Test
    void testDataSource() throws Exception
    {
        Connection connection = dataSource.getConnection();
        Assert.notNull(connection);
    }

}
