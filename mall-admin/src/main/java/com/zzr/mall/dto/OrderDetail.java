package com.zzr.mall.dto;

import com.zzr.mall.model.Order;
import com.zzr.mall.model.OrderItem;
import com.zzr.mall.model.Product;
import com.zzr.mall.model.User;

import java.util.List;


public class OrderDetail extends Order {
        private Product product;
        private List<OrderItem> orderItems;
        private User user;
}
