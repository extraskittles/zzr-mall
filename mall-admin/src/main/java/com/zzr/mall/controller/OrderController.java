package com.zzr.mall.controller;

import com.zzr.mall.dto.OrderDetail;
import com.zzr.mall.result.CommonPage;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@ResponseBody
@Api(tags = "订单管理")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/getOrderDetail")
    public CommonResult getOrderDetail(@RequestParam(required = true) int orderId){
        OrderDetail orderDetail = orderService.selectOrderDetail(orderId);
        if(orderDetail!=null){
            return CommonResult.success(orderDetail);
        }else {
            return CommonResult.failed();
        }
    }
    @GetMapping("/getOrderDetails")
    public CommonResult getOrderDetails(@RequestParam(required = true)int pageNum,@RequestParam(required = true)int pageSize){
        List<OrderDetail> orderDetails = orderService.selectOrderDetails(pageNum,pageSize);
        if(orderDetails!=null){
            return CommonResult.success(CommonPage.getPage(orderDetails));
        }else {
            return CommonResult.failed();
        }
    }
    //发货
    @PostMapping("/sendProduct")
    public CommonResult sendProduct(@RequestBody @NotNull Integer orderId){
        int i = orderService.sendProduct(orderId);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
}
