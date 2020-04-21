package com.zzr.mall.controller;


import com.zzr.mall.model.ProductImage;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@ResponseBody
public class ProductImageController {
    @Autowired
    ProductImageService productImageService;
    @GetMapping("selectProductImages")
    public CommonResult selectProductImages(int productId, int pageNum, int pageSize){
        List<ProductImage> productImages = productImageService.selectByProductId(productId, pageNum, pageSize);
        if(productImages!=null){
            return CommonResult.success(productImages);
        }else {
            return CommonResult.failed();
        }
    }
    @PostMapping("/deleteProductImage")
    public CommonResult deleteProductImage(int productImageId){
        int i = productImageService.delete(productImageId);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("/addProductImage")
    public CommonResult addProductImage(ProductImage productImage){
        int i = productImageService.insert(productImage);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
    @PostMapping("/updateProductImage")
    public CommonResult updateProductImage(ProductImage productImage){
        int i = productImageService.update(productImage);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
}
