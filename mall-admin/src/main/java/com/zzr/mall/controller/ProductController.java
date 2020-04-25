package com.zzr.mall.controller;

import com.zzr.mall.dto.ProductAddParam;
import com.zzr.mall.dto.ProductUpdateParam;
import com.zzr.mall.model.Product;
import com.zzr.mall.result.CommonPage;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.ProductService;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@ResponseBody
@Api(tags = "产品管理")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/selectProducts")
    public CommonResult selectProducts(@RequestParam(required = true) int categoryId, @RequestParam(required = true)int pageNum,@RequestParam(required = true) int pageSize){
        List<Product> products = productService.selectByCategoryId(categoryId, pageNum, pageSize);
        if(products!=null){
            return CommonResult.success(CommonPage.getPage(products));
        }else {
            return CommonResult.failed();
        }
    }
    @PostMapping("/addProduct")
    public CommonResult addProduct(@RequestBody @Validated ProductAddParam param){
        int i = productService.insert(param);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
    @PostMapping("updateProduct")
    public CommonResult updateProduct(@RequestBody @Validated ProductUpdateParam param){
        int i = productService.update(param);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("deleteProduct")
    public CommonResult deleteProduct(@RequestBody @NotNull int productId){
        int i = productService.delete(productId);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
}
