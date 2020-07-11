package com.vvlhw.supermarket.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 接收前端页码，页码第一页，每页十行
 */

@Data
public class PageVO {
    private Integer page = 0;
    private Integer size = 10;
}
