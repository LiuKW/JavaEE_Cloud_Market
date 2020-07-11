package com.vvlhw.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vvlhw.supermarket.dto.GoodDTO;
import com.vvlhw.supermarket.entity.Good;
import com.vvlhw.supermarket.dao.GoodMapper;
import com.vvlhw.supermarket.entity.GoodImages;
import com.vvlhw.supermarket.enums.GoodSaleStatus;
import com.vvlhw.supermarket.enums.GoodRecommendEnum;
import com.vvlhw.supermarket.enums.ResultEnum;
import com.vvlhw.supermarket.exception.MarketException;
import com.vvlhw.supermarket.service.GoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vvlhw.supermarket.utils.QueryWrapperUtil;
import com.vvlhw.supermarket.vo.GoodVO;
import com.vvlhw.supermarket.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService {

    @Autowired
    private GoodImagesServiceImpl goodImagesService;

    // 添加一个商品
    public void addGood(Good good)
    {
        save(good);
    }



    // 删除一个商品
    public void deleteGood(Long id)
    {
        this.baseMapper.deleteById(id);
        // TODO 删除对应商品图片，逻辑删除应该不用删除图片

    }



    // 修改一个商品
    public void updateGood(Good good)
    {
        if(StringUtils.isEmpty(good.getGoodId()))
            throw new MarketException(ResultEnum.PARAM_ERROR);
        this.baseMapper.updateById(good);
    }




    // 查询一个商品
    public Good findOne(Long id)
    {
//        GoodDTO goodDTO = this.baseMapper.findOneGood(id);
//        Long mainImageId = goodDTO.getGoodMainImageID();
//        String mainImageUrl = goodImagesService.getBaseMapper().selectById(mainImageId).getImageUrl();
//        GoodVO goodVO = new GoodVO();
//        BeanUtils.copyProperties(goodDTO, goodVO);
//        goodVO.setMainImageUrl(mainImageUrl);
//        return goodVO;


        Good good = this.baseMapper.selectById(id);
        return good;

    }



    // 分页查询分类下的商品
    public Page<Good> findCatIdGoods(Long catId, PageVO pageVO)
    {
        Page<Good> page = new Page<>(pageVO.getPage(), pageVO.getSize());
        QueryWrapper wrapper = QueryWrapperUtil.desc("good_id");    // goodId从大到小
        wrapper.eq("cat_id", catId);
        return this.baseMapper.selectPage(page, wrapper);

//        // 拿到每个商品的id
//        List<Good> goodsList = page.getRecords();
//        List<Long> mainIds = new ArrayList<>();
//        goodsList.forEach(item -> {
//            mainIds.add(item.getGoodMainimageid());
//        });
//
//        // 拿到商品的图片
//        List<GoodImages> goodImages = goodImagesService.getBaseMapper().selectBatchIds(mainIds);
//
//        Page<GoodVO> pageGoodVO = new Page<>();
//        BeanUtils.copyProperties(page, pageGoodVO);
//        List<GoodVO> goodVOs = pageGoodVO.getRecords();
//        for (int i=0; i<goodVOs.size(); i++) {
//            goodVOs.get(i).setMainImageUrl(goodImages.get(i).getImageUrl());
//        }
//
//        return pageGoodVO;
    }





    // 分页展示所有商品
    public Page<Good> findAllGoodByPage(PageVO pageVO)
    {

        Page<Good> page = new Page<>(pageVO.getPage(), pageVO.getSize());
        QueryWrapper wrapper = QueryWrapperUtil.desc("good_id");    // goodId从大到小
        return this.baseMapper.selectPage(page, wrapper);

//        // 拿到每个商品的id
//        List<Good> goodsList = page.getRecords();
//        List<Long> mainIds = new ArrayList<>();
//        goodsList.forEach(item -> {
//            mainIds.add(item.getGoodMainimageid());
//        });
//
//        // 拿到商品的图片
//        List<GoodImages> goodImages = goodImagesService.getBaseMapper().selectBatchIds(mainIds);
//
//        Page<GoodVO> pageGoodVO = new Page<>();
//        BeanUtils.copyProperties(page, pageGoodVO);
//        List<GoodVO> goodVOs = pageGoodVO.getRecords();
//        for (int i=0; i<goodVOs.size(); i++) {
//            goodVOs.get(i).setMainImageUrl(goodImages.get(i).getImageUrl());
//        }
//
//        return pageGoodVO;
    }


    // 获取推荐商品
    public List<Good> findRecommedGood()
    {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("good_isRecommend", GoodRecommendEnum.RECOMMEND.getCode());
        return this.baseMapper.selectList(wrapper);
    }


    // 商品上线
    public void onSale(Long goodId)
    {
        Good good = getById(goodId);
        good.setGoodOnsale(GoodSaleStatus.ONSALE.getCode());
        this.updateById(good);
    }

    // 商品下线
    public void offSale(Long goodId)
    {
        Good good = getById(goodId);
        good.setGoodOnsale(GoodSaleStatus.OFFSALE.getCode());
        this.updateById(good);
    }


    // 推荐商品
    public void recommend(Long goodId)
    {
        Good good = getById(goodId);
        good.setGoodIsrecommend(GoodRecommendEnum.RECOMMEND.getCode());
        this.updateById(good);
    }

    // 取消推荐商品
    public void notRecomment(Long goodId)
    {
        Good good = getById(goodId);
        good.setGoodIsrecommend(GoodRecommendEnum.NOT_RECOMMEND.getCode());
        this.updateById(good);
    }



    // TODO 添加商品主图



    // TODO 修改商品图片


    /**
     * 汉伟add
     */


    @Autowired
    GoodMapper goodMapper;

    @Override
    public List<Good> getBycatIdAndOther(Long catId, String other) {
        // 有other的情况
        // catId有值。eq这里就生效。利用eq一个重载函数
        // catId无值。eq这里不生效
        LambdaQueryChainWrapper<Good> wrapper;
        if (other != null && !other.isEmpty()) {
            // 这种lambda更好检查，不需要手敲数据库表字段，注释那种敲错了还不报错！！！
            return new LambdaQueryChainWrapper<>(this.baseMapper)
                    .eq(catId != null, Good::getCatId, catId)
                    .and(warpper -> warpper.like(Good::getGoodId, other)
                            .or().like(Good::getGoodName, other)
                            .or().like(Good::getGoodDescription, other)
                            .or().like(Good::getGoodOwner, other)
                            .or().like(Good::getGoodPrice, other)
                            .or().like(Good::getGoodSale, other))
                    .list();
        } else {
            // 没有other的情况
            // catId有值：查该分类的所有。上面第一个if自然就set进去，根据MP的动态就能查到
            // catId无值：查询所有。同上，没set就不会加分类条件
            return new LambdaQueryChainWrapper<>(this.baseMapper).eq(catId != null, Good::getCatId, catId).list();
        }

    }

    @Override
    public Long mySave(Good good) {
        goodMapper.mySave(good);
        return good.getGoodId();
    }


}
