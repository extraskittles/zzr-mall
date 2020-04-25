package com.zzr.mall.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.zzr.mall.dao.ProductImageDao;
import com.zzr.mall.dto.ProductImageAddParam;
import com.zzr.mall.mapper.ProductImageMapper;
import com.zzr.mall.model.ProductImage;
import com.zzr.mall.service.ProductImageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    ProductImageMapper productImageMapper;
@Autowired
    ProductImageDao productImageDao;

    @Override
    public List<ProductImage> selectByProductId(int productId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductImage> productImages = productImageDao.selectByProductId(productId);
        return productImages;
    }

    @Override
    public int delete(int productImageId) {
        int i = productImageMapper.deleteByPrimaryKey(productImageId);
        return i;
    }

    @Override
    public int insert(ProductImageAddParam param) {
        ProductImage productImage = new ProductImage();
        BeanUtils.copyProperties(param,productImage);
        int i = productImageMapper.insertSelective(productImage);
        return i;
    }

    @Override
    public int update(ProductImage productImage) {
        int i = productImageMapper.updateByPrimaryKeySelective(productImage);
        return i;
    }
}
