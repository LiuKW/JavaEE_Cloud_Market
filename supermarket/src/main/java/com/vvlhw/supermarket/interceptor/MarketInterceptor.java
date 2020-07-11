package com.vvlhw.supermarket.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.vvlhw.supermarket.enums.ResultEnum;
import com.vvlhw.supermarket.utils.JwtUtil;
import com.vvlhw.supermarket.utils.R;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MarketInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String method = request.getMethod().toUpperCase();
        if("OPTIONS".equals(method))
        {
            response.setStatus(200);
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "*");
            response.addHeader("Access-Control-Max-Age", "3600");
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Headers", "*");
            response.addHeader("content-type", "*");


            return true;
        }

        /**
         * 如果请求没有Authorization则表明未登录
         */
        if(request.getHeader("token") == null)
        {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getOutputStream().write(JSONObject.toJSONString(R.error(ResultEnum.UNAUTHORIZED)).getBytes());
            return false;
        }
        /**
         * 请求有Authorization
         */
        else{
            String token = request.getHeader("token");
            Claims claims = JwtUtil.checkJWT(token);
            // 验证之后为空，则代表token过期
            if(claims == null)
            {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                response.getOutputStream().write(JSONObject.toJSONString(R.error(ResultEnum.FORBIDDEN)).getBytes("UTF-8"));
                return false;
            }
        }

        return true;

    }


}