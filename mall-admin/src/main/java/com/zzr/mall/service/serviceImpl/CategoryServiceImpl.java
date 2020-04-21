package com.zzr.mall.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.zzr.mall.dao.CategoryDao;
import com.zzr.mall.mapper.CategoryMapper;
import com.zzr.mall.model.Category;
import com.zzr.mall.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryDao categoryDao;

    @Override
    public int delete(int id) {
        int i = categoryMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int update(Category category) {
        int i = categoryMapper.updateByPrimaryKeySelective(category);
        return i;
    }

    @Override
    public int insert(Category category) {
        int i = categoryMapper.insertSelective(category);
        return i;
    }

    @Override
    public List<Category> selectByPage(Integer id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categories = categoryDao.selectAll();
        return categories;
    }
}
