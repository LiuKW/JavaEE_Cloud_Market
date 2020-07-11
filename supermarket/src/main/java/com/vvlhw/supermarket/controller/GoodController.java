package com.vvlhw.supermarket.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vvlhw.supermarket.dto.GoodDTO;
import com.vvlhw.supermarket.entity.Good;
import com.vvlhw.supermarket.service.impl.GoodServiceImpl;
import com.vvlhw.supermarket.utils.R;
import com.vvlhw.supermarket.vo.GoodVO;
import com.vvlhw.supermarket.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Api(tags = "商品模块")
@RestController
@RequestMapping("/supermarket/good")
public class GoodController {
    
    @Autowired
    private GoodServiceImpl goodService;


    @ApiOperation("查询一个商品，传入商品id值，ok")
    @GetMapping("/{goodId}")
    public R findOne(@PathVariable("goodId") Long id)
    {
        Good good = goodService.findOne(id);
        return R.ok().put("good", good);
    }


    @ApiOperation("分页查询所有商品，ok")
    @GetMapping("/pages")
    public R findAllPages(PageVO pageVO)
    {
        Page<Good> goodsList = goodService.findAllGoodByPage(pageVO);
        return R.ok().put("goods", goodsList);
    }

    @ApiOperation("分页查询分类下的商品，ok")
    @GetMapping("/pages/{catId}")
    public R findPageByCatId(PageVO pageVO, @PathVariable("catId") Long catId)
    {
        Page<Good> goodsList = goodService.findCatIdGoods(catId, pageVO);
        return R.ok().put("goods", goodsList);
    }

    @ApiOperation("查询推荐商品")
    @GetMapping("/recommend")
    public R findRecomment()
    {
        List<Good> recommedGood = goodService.findRecommedGood();
        return R.ok().put("recommends", recommedGood);
    }



    @ApiOperation("添加一个商品，ok")
    @PostMapping("/admin/good")
    public R addGood(@Valid @RequestBody Good good)
    {
        Long insertGid = goodService.mySave(good);
        return R.ok().put("insertGid", insertGid);
    }


    @ApiOperation("删除一个商品，ok")
    @DeleteMapping("/admin/good/{goodId}")
    public R deleteOneGood(@PathVariable("goodId") Long goodId)
    {
        goodService.deleteGood(goodId);
        return R.ok();
    }

    @ApiOperation("修改商品，ok")
    @PutMapping("/admin/good")
    public R updateOneGood(@Valid @RequestBody Good good)
    {
        goodService.updateGood(good);
        return R.ok();
    }


    @ApiOperation("商品上线，ok")
    @GetMapping("/admin/good/sale/{goodId}")
    public R onSale(@PathVariable("goodId") Long goodId)
    {
        goodService.onSale(goodId);
        return R.ok();
    }


    @ApiOperation("商品下线，ok")
    @GetMapping("/admin/good/sale/off/{goodId}")
    public R offSale(@PathVariable("goodId") Long goodId)
    {
        goodService.offSale(goodId);
        return R.ok();
    }


    @ApiOperation("推荐商品，ok")
    @GetMapping("/admin/good/recommend/{goodId}")
    public R recommend(@PathVariable("goodId") Long goodId)
    {
        goodService.recommend(goodId);
        return R.ok();
    }



    @ApiOperation("取消推荐商品，ok")
    @GetMapping("/admin/good/recommend/cancel/{goodId}")
    public R notRecommend(@PathVariable("goodId") Long goodId)
    {
        goodService.notRecomment(goodId);
        return R.ok();
    }





    // TODO 上传商品图片，
    //
    // TODO，修改商品图片



    /**
     * 删除商品信息（可批量，数组嘛）
     */
    @DeleteMapping("/admin/good/deletes")
    @ApiOperation("删除商品信息（可批量，数组嘛）")
    public R delete(@RequestBody Long[] goodIds) {
        goodService.removeByIds(Arrays.asList(goodIds));
        return R.ok();
    }


    /**
     * 模糊查询：根据分类id and goodEntity的所有字段
     */
    @ApiOperation("查询接口，可模糊查询")
    @GetMapping("/search")
    public R search(@ApiParam("写类别")@RequestParam(value = "catId", required = false) Long catId, @ApiParam("可写可不写，不写即只按分类查")@RequestParam(value = "other", required = false) String other){
        List<Good> goods = goodService.getBycatIdAndOther(catId, other);
        return R.ok().put("goods", goods);
    }


}

