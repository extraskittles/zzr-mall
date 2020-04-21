package com.zzr.mall.service;

import com.zzr.mall.model.*;

import java.util.List;

public interface ProductService {
    List<Product> selectByCategoryId(int categoryId, int pageNum, int pageSize);
    int insert(Product product);
    int update(Product product);
    int delete(int productId);
}
