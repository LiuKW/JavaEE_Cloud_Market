package com.vvlhw.supermarket.utils;

import com.vvlhw.supermarket.entity.User;
import com.vvlhw.supermarket.enums.ResultEnum;
import com.vvlhw.supermarket.exception.MarketException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    public static final String SUBJECT = "onehee";

    public static final long EXPIRE = 1000*60*60*24*7;  //有效时间一周

    //秘钥
    public static final  String APPSECRET = "lalalala";

    /**
     * 生成jwt
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("userId",user.getUserId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();
        return token;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token ){

        try{
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return  claims;

        }catch (Exception e){ }
        return null;
    }


    public static Long getUserIdByToken(String token)
    {
        Claims claims = checkJWT(token);
        String i = claims.get("userId").toString();
        return Long.valueOf(i);
    }



}