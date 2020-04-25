package com.zzr.mall.service;

import com.zzr.mall.dto.OrderDetail;

import java.util.List;

public interface OrderService {
    OrderDetail selectOrderDetail(int orderId);
    List<OrderDetail> selectOrderDetails(int pageNum,int pageSize);
    int sendProduct(int orderId);
}
