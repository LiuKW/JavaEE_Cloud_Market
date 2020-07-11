package com.vvlhw.supermarket.controller;


import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.vvlhw.supermarket.entity.GoodImages;
import com.vvlhw.supermarket.service.GoodImagesService;
import com.vvlhw.supermarket.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 商品图片集表 前端控制器
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@RestController
@RequestMapping("/supermarket/good-images")
@Api(tags = "图片模块")
public class GoodImagesController {
    @Autowired
    private GoodImagesService goodImagesService;

    /**
     * 查询商品gid的所有图片
     */
    @ApiOperation("查询某个商品gid的所有图片")
    @GetMapping("/info/{gid}")
    public R info(@PathVariable("gid") Long gid){
        List<GoodImages> list = new LambdaQueryChainWrapper<>(goodImagesService.getBaseMapper()).eq(GoodImages::getGoodId, gid).list();
        return R.ok().put("goodImages", list);
    }

    /**
     * 批量保存图片
     * 因为一般图片集都有好几张
     */
    @ApiOperation("批量保存图片，传图片id，[id1, id2, ....]")
    @PutMapping("/save")
    public R save(@RequestBody GoodImages[] goodImages){
        goodImagesService.saveBatch(Arrays.asList(goodImages));
        return R.ok();
    }
}

