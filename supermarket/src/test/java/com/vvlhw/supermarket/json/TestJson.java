package com.vvlhw.supermarket.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vvlhw.supermarket.dto.OrderD;
import com.vvlhw.supermarket.entity.Good;
import com.vvlhw.supermarket.entity.Goodtt;
import com.vvlhw.supermarket.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestJson {


    @Test
    void testTransJson()
    {
        List<Goodtt> goodsList = new ArrayList<>();
        goodsList.add(new Goodtt(1L, 3, new BigDecimal(20)));
        goodsList.add(new Goodtt(2L, 2, new BigDecimal(20)));

        Map<String, Object> map = new HashMap<>();
        map.put("userId", 15);
        map.put("totalPrice", 88.88);
        map.put("orderAddress", "广东省东莞市");
        map.put("goodsList", goodsList);
        String shoppingCart = JSONObject.toJSONString(map);
        System.out.println(shoppingCart);
    }


    @Test
    void testParseJson()
    {
        List<Goodtt> goodsList = new ArrayList<>();
        goodsList.add(new Goodtt(1L, 3, new BigDecimal(20)));
        goodsList.add(new Goodtt(2L, 2, new BigDecimal(20)));

        Map<String, Object> map = new HashMap<>();
        map.put("userId", 15);
        map.put("totalPrice", 88.88);
        map.put("orderAddress", "广东省东莞市");
        map.put("goodsList", goodsList);
        String shoppingCart = JSONObject.toJSONString(map);

        OrderD orderD = JSONObject.parseObject(shoppingCart, OrderD.class);
        System.out.println(orderD);
    }


    @Test
    void getOrder()
    {
        List<Goodtt> goodsList = new ArrayList<>();
        goodsList.add(new Goodtt(1L, 3, new BigDecimal(20)));
        goodsList.add(new Goodtt(2L, 2, new BigDecimal(20)));

        Map<String, Object> map = new HashMap<>();
        map.put("userId", 15);
        map.put("totalPrice", 88.88);
        map.put("orderAddress", "广东省东莞市");
        map.put("goodsList", goodsList);
        String shoppingCart = JSONObject.toJSONString(map);
        System.out.println(shoppingCart);
    }



    @Test
    void getUser()
    {
        User user  = new User();
        user.setUserNickname("Mike").setUserPhone("7474185852").setUserPassword("123456789");
        String u = JSONObject.toJSONString(user);
        System.out.println(u);
    }

    @Test
    void getGood()
    {
        Good good = new Good();
        good.setGoodName("烟花").setGoodDescription("半夜三更放烟花")
                .setGoodOwner("烟花集团").setCatId(13L).setGoodPrice(new BigDecimal(150));
        String goodStr = JSONObject.toJSONString(good);
        System.out.println(goodStr);

    }


}
