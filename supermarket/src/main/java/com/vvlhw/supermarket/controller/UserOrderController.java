package com.vvlhw.supermarket.controller;


import com.alipay.api.AlipayApiException;
import com.vvlhw.supermarket.dto.UserOrderDTO;
import com.vvlhw.supermarket.enums.OrderStatusEnum;
import com.vvlhw.supermarket.service.impl.UserOrderServiceImpl;
import com.vvlhw.supermarket.utils.R;
import com.vvlhw.supermarket.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
//@RestController
//@RequestMapping("/supermarket/user-order")
//public class UserOrderController {
//
//    @Autowired
//    private UserOrderServiceImpl userOrderService;
//
//    @PostMapping("/create")
//    public R createOrder(@RequestBody String cartJson)
//    {
//        userOrderService.create(cartJson);
//        return R.ok();
//    }
//
//}


@RestController
@RequestMapping("/supermarket/user-order")
@Api(tags = "订单模块")
public class UserOrderController {

    @Autowired
    private UserOrderServiceImpl userOrderService;

    //下单
    @ApiOperation("下单")
    @PostMapping("/placeorder")
    public R placeOrder(@RequestBody UserOrderDTO orderDTO) {
        return R.ok().put("orderId", userOrderService.insertOrder(orderDTO).toString());
    }

    //删除订单
    @ApiOperation("删除订单")
    @DeleteMapping("/deleteorder")
    public R deleteOrder(Long orderId) {
        userOrderService.deleteOrder(orderId);
        return R.ok();
    }

    //修改订单
//    @PutMapping("/updateorder")
//    public R updateOrder(@RequestBody UserOrder userOrder){
//        userOrderService.UpdateOrder(userOrder);
//        return R.ok();
//    }

    //分页查询
    @ApiOperation("分页查询")
    @GetMapping("/querydivbypage/{userId}")
    public R queryDivByPage(@RequestBody PageVO page, @PathVariable("userId") Long userId) {
        return R.ok().put("orders", userOrderService.queryDivByPage(page, userId));
    }

    //查询单个订单
    @ApiOperation("查询单个订单")
    @GetMapping("/query")
    public R query(Long orderId)
    {
        return R.ok().put("detail", userOrderService.query(orderId));
    }

    //取消订单
    @ApiOperation("取消订单")
    @PutMapping("/cancelorder")
    public R cancelOrder(Long orderId){
        userOrderService.changeOrderStatus(orderId, OrderStatusEnum.CANCEL);
        return R.ok();
    }

    //支付
    @ApiOperation("支付")
    @GetMapping("/payorder")
    public String pay(Long orderId) throws AlipayApiException {
        return userOrderService.createTrade(orderId);
    }

    //支付成功后
    @ApiOperation("支付成功后")
    @GetMapping(value = "/checkpay")
    public R checkPay(@RequestParam("out_trade_no")Long orderId) {
        userOrderService.salesPlus(orderId);
        userOrderService.changeOrderStatus(orderId, OrderStatusEnum.SUCCESS);
        return R.ok().put("状态", "支付成功，请耐心等待商家发货。");
    }
}



