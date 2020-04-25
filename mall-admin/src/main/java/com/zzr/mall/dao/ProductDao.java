package com.zzr.mall.dao;


import com.zzr.mall.model.Product;

import java.util.List;

public interface ProductDao {


    List<Product> selectByCategoryId(int categoryId);
}