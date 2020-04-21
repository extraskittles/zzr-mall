package com.zzr.mall.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.zzr.mall.dao.ProductDao;
import com.zzr.mall.mapper.ProductMapper;
import com.zzr.mall.model.Product;
import com.zzr.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductDao productDao;
    @Override
    public List<Product> selectByCategoryId(int categoryId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> products = productDao.selectByCategoryId(categoryId);
        return products;
    }

    @Override
    public int insert(Product product) {
        int i = productMapper.insert(product);
        return i;
    }

    @Override
    public int update(Product product) {
        int i = productMapper.updateByPrimaryKeySelective(product);
        return i;
    }

    @Override
    public int delete(int productId) {
        int i = productMapper.deleteByPrimaryKey(productId);
        return i;
    }
}
