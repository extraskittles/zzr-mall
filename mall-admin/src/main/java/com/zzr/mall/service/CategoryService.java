package com.zzr.mall.service;

import com.zzr.mall.model.Category;
import java.util.List;

public interface CategoryService {
    int delete(int id);
    int update(Category category);
    int insert(Category category);
    List<Category> selectByPage(Integer id, int pageNum, int pageSize);
}
