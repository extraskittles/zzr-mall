package com.zzr.mall.mapper;

import com.zzr.mall.model.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKeyWithBLOBs(Category record);

    int updateByPrimaryKey(Category record);
}