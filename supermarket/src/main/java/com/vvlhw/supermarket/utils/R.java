package com.vvlhw.supermarket.utils;

/**
 * @author VVlhw
 * @date 2020/7/6 - 15:28
 */

import com.vvlhw.supermarket.enums.ResultEnum;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", ResultEnum.SUCCESS.getCode());
        put("msg", ResultEnum.SUCCESS.getMessage());
    }

    public static R error() {
        return error(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMessage());
    }

    public static R error(String msg) {
        return error(ResultEnum.FAIL.getCode(), msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R error(ResultEnum resultEnum)
    {
        R r = new R();
        r.put("code", resultEnum.getCode());
        r.put("msg", resultEnum.getMessage());
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
