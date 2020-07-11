package com.vvlhw.supermarket.service.good;

import com.vvlhw.supermarket.dto.GoodDTO;
import com.vvlhw.supermarket.service.impl.GoodServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestGood {


    @Autowired
    private GoodServiceImpl goodService;


    @Test
    void testFindOneGood()
    {
        GoodDTO oneGood = goodService.getBaseMapper().findOneGood(3L);
        System.out.println(oneGood);
    }



}
