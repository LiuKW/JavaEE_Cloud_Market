package com.vvlhw.supermarket.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;

@Data
public class QueryWrapperUtil {

    public static QueryWrapper desc(String... columns)
    {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc(columns);     // goodId从大到小
        return wrapper;
    }

    public static QueryWrapper asc(String... columns)
    {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByAsc(columns);     // goodId从大到小
        return wrapper;
    }

}
