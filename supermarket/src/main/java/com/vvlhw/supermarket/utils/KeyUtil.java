package com.vvlhw.supermarket.utils;

import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一的主键
     */
    public static synchronized Long getKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return Long.valueOf(System.currentTimeMillis() + String.valueOf(number));
    }

    /**
     * 获取短信验证码
     * @return
     */
    public static synchronized String getMsgCode()
    {
        Random random = new Random();
        Integer number = random.nextInt(9000) + 1000;
        return number.toString();
    }

}