package com.zzr.mall.dao;


import com.zzr.mall.dto.OrderDetail;

public interface OrderDao {


    OrderDetail selectDetail(Integer id);
}