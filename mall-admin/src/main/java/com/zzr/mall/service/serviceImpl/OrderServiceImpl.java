package com.zzr.mall.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zzr.mall.Emum.OrderStatus;
import com.zzr.mall.dao.OrderDetailDao;
import com.zzr.mall.dto.OrderDetail;
import com.zzr.mall.dto.OrderItemDetail;
import com.zzr.mall.mapper.OrderMapper;
import com.zzr.mall.model.Order;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDetailDao orderDetailDao;
    @Autowired
    OrderMapper orderMapper;
    @Override
    public OrderDetail selectOrderDetail(int orderId) {
        OrderDetail orderDetail = orderDetailDao.selectDetail(orderId);
        List<OrderItemDetail> orderItemDetails = orderDetail.getOrderItemDetails();
        float prices=0;
        int numbers=0;
        for(OrderItemDetail orderItemDetail:orderItemDetails){
            prices+=orderItemDetail.getProduct().getPromotePrice();
            numbers+=orderItemDetail.getNumber();
        }
        orderDetail.setPrices(prices);
        orderDetail.setNumbers(numbers);
        return orderDetail;
    }

    @Override
    public List<OrderDetail> selectOrderDetails(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderDetail> orderDetails = orderDetailDao.selectDetails();
        for(OrderDetail orderDetail:orderDetails){
            List<OrderItemDetail> orderItemDetails = orderDetail.getOrderItemDetails();
            float prices=0;
            int numbers=0;
            for(OrderItemDetail orderItemDetail:orderItemDetails){
                prices+=orderItemDetail.getProduct().getPromotePrice();
                numbers+=orderItemDetail.getNumber();
            }
            orderDetail.setPrices(prices);
            orderDetail.setNumbers(numbers);
        }
        return orderDetails;
    }

    @Override
    public int sendProduct(int orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        int i=0;
        if(order!=null){
            order.setStatus(OrderStatus.DELIVERING.getStatus());
            order.setDeliveryDate(new Date());
             i = orderMapper.updateByPrimaryKeySelective(order);
        }
            return i;
    }
}
