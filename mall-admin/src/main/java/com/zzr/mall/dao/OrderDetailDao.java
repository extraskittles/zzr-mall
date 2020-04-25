package com.zzr.mall.dao;

import com.zzr.mall.dto.OrderDetail;

import java.util.List;


public interface OrderDetailDao {
    OrderDetail selectDetail(int orderId);
    List<OrderDetail> selectDetails();
}
