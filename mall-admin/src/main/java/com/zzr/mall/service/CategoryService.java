package com.zzr.mall.service;

import com.zzr.mall.dto.CategoryAddParam;
import com.zzr.mall.model.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {
    int delete(int id);
    int update(Category category);
    int insert(CategoryAddParam param);
    List<Category> selectByPage( int pageNum, int pageSize);
    Category selectCategory(int id);

}
