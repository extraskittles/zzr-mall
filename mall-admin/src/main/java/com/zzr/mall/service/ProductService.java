package com.zzr.mall.service;

import com.zzr.mall.dto.ProductAddParam;
import com.zzr.mall.dto.ProductUpdateParam;
import com.zzr.mall.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> selectByCategoryId(int categoryId, int pageNum, int pageSize);
    int insert(ProductAddParam param);
    int update(ProductUpdateParam param);
    int delete(int productId);
    String upload(MultipartFile file);
    Product selectOne(int id);
}
