package com.vvlhw.supermarket.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@RestController
@RequestMapping("/supermarket/comment")
@Api(tags = "评论操作")
public class CommentController {
    @GetMapping("/kwkw")
    @ApiOperation("刘恺威测试swagger")
    public String kwkw() {
        return "刘恺威";
    }
}

