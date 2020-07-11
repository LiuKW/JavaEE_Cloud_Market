package com.vvlhw.supermarket.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOrder {


    @Test
    void testOrder()
    {
        UserOrder order = new UserOrder();
        System.out.println(order);
    }

}
