package com.zzr.mall.controller;

import com.zzr.mall.model.Product;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/selectProducts")
    public CommonResult selectProducts(int categoryId, int pageNum, int pageSize){
        List<Product> products = productService.selectByCategoryId(categoryId, pageNum, pageSize);
        if(products!=null){
            return CommonResult.success(products);
        }else {
            return CommonResult.failed();
        }
    }
    @PostMapping("/addProduct")
    public CommonResult addProduct(@RequestBody Product product){
        int i = productService.insert(product);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
    @PostMapping("updateProduct")
    public CommonResult updateProduct(@RequestBody Product product){
        int i = productService.update(product);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("deleteProduct")
    public CommonResult deleteProduct(@RequestBody int productId){
        int i = productService.delete(productId);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
}
