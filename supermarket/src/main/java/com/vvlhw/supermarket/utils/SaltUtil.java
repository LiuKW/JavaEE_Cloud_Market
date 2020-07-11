package com.vvlhw.supermarket.utils;

import java.util.UUID;

public class SaltUtil {

    public static synchronized String  getSalt()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
