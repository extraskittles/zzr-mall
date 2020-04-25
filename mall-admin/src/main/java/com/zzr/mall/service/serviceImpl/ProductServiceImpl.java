package com.zzr.mall.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.zzr.mall.dao.ProductDao;
import com.zzr.mall.dto.ProductAddParam;
import com.zzr.mall.dto.ProductUpdateParam;
import com.zzr.mall.mapper.ProductMapper;
import com.zzr.mall.model.Product;
import com.zzr.mall.service.ProductService;
import com.zzr.mall.utils.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;
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
    public int insert(ProductAddParam param) {
        Product product = new Product();
        product.setCid(param.getCid());
        product.setName(param.getName());
        product.setCreateDate(new Date());
        product.setOriginalPrice(param.getOriginalPrice());
        product.setPromotePrice(param.getPromotePrice());
        product.setStock(param.getStock());
        product.setSubTitle(param.getSubTitle());
        int i = productMapper.insert(product);
        return i;
    }

    @Override
    public int update(ProductUpdateParam param) {
        Product product = new Product();
        BeanUtils.copyProperties(param,product);
        int i = productMapper.updateByPrimaryKeySelective(product);
        return i;
    }

    @Override
    public int delete(int productId) {
        int i = productMapper.deleteByPrimaryKey(productId);
        return i;
    }

    @Override
    public String upload(MultipartFile file) {
        String url = FileUtil.saveWindowPicture(file, FileUtil.WINDOWDIR);
        return url;
    }

    @Override
    public Product selectOne(int id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }
}
