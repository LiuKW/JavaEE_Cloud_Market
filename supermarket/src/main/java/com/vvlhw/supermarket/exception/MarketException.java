package com.vvlhw.supermarket.exception;

import com.vvlhw.supermarket.enums.ResultEnum;
import lombok.Data;

@Data
public class MarketException extends RuntimeException {



    private Integer code;


    public MarketException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }


    public MarketException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
