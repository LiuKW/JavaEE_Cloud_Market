package com.vvlhw.supermarket;

import com.vvlhw.supermarket.entity.Category;
import com.vvlhw.supermarket.entity.User;
import com.vvlhw.supermarket.service.CategoryService;
import com.vvlhw.supermarket.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class SupermarketApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        Category category = new Category();
        category.setCatName("lhw3测试少小时");
        categoryService.getBaseMapper().insert(category);
    }

    @Autowired
    DataSource dataSource;

    @Transactional
    @Test
    void testInsertUser()
    {

        User user = new User();
        user.setUserNickname("Mike");
        user.setUserPhone("15915915911");
        user.setUserPassword("123");
        userService.save(user);

    }


    /**
     * TODO 订单模块
     * 创建订单
     * 删除一个订单
     * 修改订单
     * 查询一个订单
     * 分页查询所有订单
     * 取消订单
     * 支付订单
     */


    // TODO 支付功能
    // TODO 上传图片
    // TODO 短信验证
    // TODO 评论
    // TODO　分类
    // TODO 跨域问题
    // TODO 几个大报告
















}
