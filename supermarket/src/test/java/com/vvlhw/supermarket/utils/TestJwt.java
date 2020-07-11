package com.vvlhw.supermarket.utils;

import com.vvlhw.supermarket.entity.User;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.sql.DataSource;

@SpringBootTest
public class TestJwt {



    @Test
    void testGetId()
    {
        User user = new User();
        user.setUserId(1L);
        String token = JwtUtil.geneJsonWebToken(user);
        System.out.println(token);
        Claims claims = JwtUtil.checkJWT(token);
        String id = claims.get("userId").toString();
        Long ids = Long.valueOf(id);


        System.out.println(ids);
    }




}
