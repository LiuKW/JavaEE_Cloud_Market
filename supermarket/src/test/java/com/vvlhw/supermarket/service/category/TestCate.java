package com.vvlhw.supermarket.service.category;

import com.vvlhw.supermarket.service.impl.CategoryServiceImpl;
import com.vvlhw.supermarket.vo.CategoryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCate {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    void testCatePage()
    {
        CategoryVO cates = categoryService.findGoodsByCateId(13L);
        System.out.println();System.out.println();System.out.println();System.out.println();
        cates.getGoods().forEach(System.out::println);
        System.out.println();System.out.println();System.out.println();System.out.println();

    }
}
