package com.zzr.mall.dao;


import com.zzr.mall.model.ProductImage;

import java.util.List;

public interface ProductImageDao {


    List<ProductImage> selectByProductId(int productId);
}