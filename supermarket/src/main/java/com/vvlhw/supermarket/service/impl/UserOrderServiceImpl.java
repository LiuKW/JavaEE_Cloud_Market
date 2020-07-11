package com.vvlhw.supermarket.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vvlhw.supermarket.config.AlipayConfig;
import com.vvlhw.supermarket.dto.UserOrderDTO;
import com.vvlhw.supermarket.entity.Good;
import com.vvlhw.supermarket.entity.UserOrder;
import com.vvlhw.supermarket.dao.UserOrderMapper;
import com.vvlhw.supermarket.enums.OrderStatusEnum;
import com.vvlhw.supermarket.service.UserOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vvlhw.supermarket.vo.PageVO;
import com.vvlhw.supermarket.vo.UserOrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
//@Service
//public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {
//
//    // 用户下单，创建订单
//    public void create(String shoppingCartJson)
//    {
//        CartDTO shoppingCart = JSONObject.parseObject(shoppingCartJson, CartDTO.class);
//        List<SingleGoodDTO> goodsList = shoppingCart.getGoodsList();
//
//        /** orderContent格式转化
//         *  保存：id，数量，当时价格
//         */
//        String orderContent = JSONObject.toJSONString(goodsList);
//
//        UserOrder userOrder = new UserOrder();
//        userOrder.setUserId(shoppingCart.getUserId());
//        userOrder.setOrderContent(orderContent);
//        userOrder.setOrderPrice(shoppingCart.getTotalPrice());
//        userOrder.setOrderAddress(shoppingCart.getOrderAddress());
//        this.baseMapper.insert(userOrder);
//    }
//
//
//    // 用户取消订单
//    public void orderCancel(Long orderId)
//    {
//        UserOrder userOrder = this.baseMapper.selectById(orderId);
//        userOrder.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
//        this.baseMapper.updateById(userOrder);
//    }
//
//    // TODO 查询一个订单
//    // TODO 分页查询用户下的所有订单
//
//    // TODO 分页查询所有订单后台使用
//
//    // TODO 支付成功，讲订单状态改为已支付，商品购买量+1
//    // TODO 取消订单，用户拥有该商品
//
//
//}




@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {

    @Autowired
    private GoodServiceImpl goodService;


    //创建订单
    public Long insertOrder(UserOrderDTO orderDTO) {
        UserOrder userOrder = new UserOrder();

        userOrder.setUserId(orderDTO.getUserId());
        userOrder.setOrderContent(orderDTO.getGoodsList().toString());
        userOrder.setOrderPrice(orderDTO.getTotalPrice());
        userOrder.setOrderAddress(orderDTO.getOrderAddress());
        save(userOrder);

        return userOrder.getOrderId();
    }

    //删除订单
    public void deleteOrder(Long orderId){
        removeById(orderId);
    }

    //修改订单
//    public void UpdateOrder(UserOrder userOrder) {
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("order_id", userOrder.getOrderId());
//        update(userOrder, wrapper);
//    }

    //分页查询
    public Page<UserOrder> queryDivByPage(PageVO page, Long userId) {
        Page<UserOrder> pUserOrder = new Page<>(page.getPage(), page.getSize());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        return this.baseMapper.selectPage(pUserOrder, queryWrapper);
    }

    //查询单个订单（除UserOrder中内容外还需要 名称 和 首图地址）
    public UserOrder query(Long orderId) {
        UserOrder userOrder = this.getById(orderId);
        JSONArray array = JSONObject.parseArray(userOrder.getOrderContent());
        for (Object obj:array) {

            JSONObject value = (JSONObject) JSONObject.toJSON(obj);
            Long goodId = value.getLong("goodId");

            //TODO 根据Id获取Good
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("good_id", goodId);
            Good good = (goodService.getBaseMapper()).selectOne(wrapper);

            value.put("goodName", good.getGoodName());
            value.put("goodMainImageUrl", good.getGoodMainimageurl());
        }
        userOrder.setOrderContent(array.toString());
        return userOrder;
//        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(userOrder);
//        return jsonObject;
    }

    //修改订单状态
    public void changeOrderStatus(Long orderId, OrderStatusEnum orderStatus){
        UserOrder userOrder = getById(orderId);
        userOrder.setOrderStatus(orderStatus.getCode());
        this.updateById(userOrder);
    }

    //创建支付订单
    public String createTrade(Long orderId) throws AlipayApiException {
        String tradeUrl = "";
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("order_id", orderId);
        UserOrder userOrder = this.baseMapper.selectOne(wrapper);

//        if(userOrder.getOrderStatus() == OrderStatusEnum.CANCEL.getCode())
//            return R.error("该订单已取消");

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient
                (
                        AlipayConfig.gatewayUrl,
                        AlipayConfig.app_id,
                        AlipayConfig.merchant_private_key,
                        "json",
                        AlipayConfig.charset,
                        AlipayConfig.alipay_public_key,
                        AlipayConfig.sign_type
                );

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = userOrder.getOrderId().toString();
        //付款金额，必填
        String total_amount = userOrder.getOrderPrice().toString();
        //订单名称，必填
        String subject = "test"+out_trade_no;

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        tradeUrl = alipayClient.pageExecute(alipayRequest).getBody();

        return tradeUrl;
    }


    //销量+1
    public void salesPlus(Long orderId) {
        UserOrder userOrder = getById(orderId);
        JSONArray array = JSONObject.parseArray(userOrder.getOrderContent());
        for (Object obj:array) {
            JSONObject value = (JSONObject) JSONObject.toJSON(obj);
            Long goodId = value.getLong("goodId");
            Good good = goodService.getById(goodId);
            good.setGoodSale(good.getGoodSale() + 1);
            goodService.updateById(good);
        }
    }
}



