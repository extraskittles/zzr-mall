package com.zzr.mall.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.zzr.mall.dao.CategoryDao;
import com.zzr.mall.dto.CategoryAddParam;
import com.zzr.mall.mapper.CategoryMapper;
import com.zzr.mall.model.Category;
import com.zzr.mall.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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
    public int insert(CategoryAddParam param) {
        Category category = new Category();
        BeanUtils.copyProperties(param,category);
        int i = categoryMapper.insertSelective(category);
        return i;
    }

    @Override
    public List<Category> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categories = categoryDao.selectAll();
        return categories;
    }

    @Override
    public Category selectCategory(int id) {
        Category category = categoryDao.selectById(id);
        return category;
    }

}
