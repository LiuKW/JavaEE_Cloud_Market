package com.vvlhw.supermarket.controller;


import com.vvlhw.supermarket.entity.Category;
import com.vvlhw.supermarket.service.CategoryService;
import com.vvlhw.supermarket.service.impl.CategoryServiceImpl;
import com.vvlhw.supermarket.utils.R;
import com.vvlhw.supermarket.vo.CategoryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */

@RestController
@RequestMapping("/supermarket/category")
@Api(tags = "分类操作")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有分类信息
     */
    @GetMapping("/list")
    @ApiOperation("查询所有分类信息")
    public R list() {
        List<Category> categories = categoryService.list();
        return R.ok().put("categories", categories);
    }

    /**
     * 查询某一个分类信息
     */
    @GetMapping("/info/{catId}")
    @ApiOperation("查询某一个分类信息")
    public R info(@PathVariable("catId") Long catId) {
        Category category = categoryService.getById(catId);
        return R.ok().put("category", category);
    }

    /**
     * 保存新的分类信息
     */
    @PutMapping("/save")
    @ApiOperation("保存新的分类信息")
    public R save(@RequestBody Category category) {
        categoryService.save(category);
        return R.ok();
    }

    /**
     * 修改某一个分类信息
     * TODO: 可能前端传来的并没有version，我们这里其实应该先查询一次
     */
    @PostMapping("/update")
    @ApiOperation("修改某一个分类信息")
    public R update(@RequestBody Category category) {
        Integer old_version = categoryService.getById(category.getCatId()).getVersion();
        category.setVersion(old_version);
        categoryService.updateById(category);
        return R.ok();
    }

    /**
     * 删除分类信息（可批量，数组嘛）
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除分类信息（可批量，数组嘛）")
    public R delete(@RequestBody Long[] catIds) {
        categoryService.removeByIds(Arrays.asList(catIds));
        return R.ok();
    }

    /*
    @GetMapping("/lhw")
    @ApiOperation("梁汉伟测试swagger")
    public R lhw() {
        return R.ok().put("name", "梁汉伟");
    }

    @PutMapping("testAdd")
    @ApiOperation("梁汉伟测试新增分类")
    public void addCategory() {
        Category category = new Category();
        category.setCatName("lhw3测试少了8小时");
        categoryService.getBaseMapper().insert(category);
    }

    @PostMapping("testUpdate")
    @ApiOperation("梁汉伟测试更新分类")
    public void updateCategory() {
        Category category = categoryService.getBaseMapper().selectById(3L);
//        category.setUpdateTime(null);

//        Category category1 = new Category();
//        category1.setCatId(category.getCatId());
//        category1.setVersion(category.getVersion());
        category.setCatName("俊威叫我访问数据库");
        categoryService.getBaseMapper().updateById(category);
    }
     */
}