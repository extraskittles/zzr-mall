package com.zzr.mall.dao;


import com.zzr.mall.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> selectAll();
    Category selectById(int id);
}