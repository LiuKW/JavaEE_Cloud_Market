package com.vvlhw.supermarket.handler;

import com.vvlhw.supermarket.enums.ResultEnum;
import com.vvlhw.supermarket.exception.MarketException;
import com.vvlhw.supermarket.utils.R;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R methodArgumentNotValidException(MethodArgumentNotValidException e)
    {

        R r = R.error();
        e.getBindingResult().getFieldErrors().forEach(
                item -> {r.put(item.getField(), item.getDefaultMessage());}
        );
        return r;
    }

    @ExceptionHandler(value = MarketException.class)
    public R marketExceptionHandler(HttpServletRequest request, MarketException e)
    {
        return R.error(e.getCode(), e.getMessage());
    }

    //标识异常的注解
    @ExceptionHandler(value = Exception.class)
    public R exceptionHander(HttpServletRequest request, Exception e) throws Exception {

        R r = R.error(ResultEnum.FAIL.getCode(), e.getMessage());
        return r;
    }
}