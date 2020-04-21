package com.zzr.mall.service;

import com.zzr.mall.model.*;

import java.util.List;

public interface ProductImageService {
    List<ProductImage> selectByProductId(int productId, int pageNum, int pageSize);
    int delete(int productImageId);
    int insert(ProductImage productImage);
    int update(ProductImage productImage);
}
