package com.zzr.mall.dto;

import com.zzr.mall.model.OrderItem;
import com.zzr.mall.model.Product;

public class OrderItemDetail extends OrderItem {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}

