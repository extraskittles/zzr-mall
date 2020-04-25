package com.zzr.mall.controller;

import com.zzr.mall.dto.CategoryAddParam;
import com.zzr.mall.model.Category;
import com.zzr.mall.result.CommonPage;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.CategoryService;
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
@Api(tags = "分类管理")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/selectCategories")
    public CommonResult selectCategories(@RequestParam(name = "pageNum",required = true) int pageNum, @RequestParam(name = "pageSize",required = true)int pageSize){
        List<Category> categories = categoryService.selectByPage(pageNum,pageSize);
        if(categories!=null){
            return CommonResult.success(CommonPage.getPage(categories));
        }else {
            return CommonResult.failed();
        }
    }
    @GetMapping("/selectCategory")
    public CommonResult selectCategory(@RequestParam(name = "id",required=true)int id){
        Category category = categoryService.selectCategory(id);
        if(category!=null){
            return CommonResult.success(category);
        }else {
            return CommonResult.failed();
        }
    }
    @PostMapping("/addCategory")
    public CommonResult addCategory(@Validated @RequestBody CategoryAddParam param){
        int i = categoryService.insert(param);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("/updateCategory")
    public CommonResult updateCategory(@Validated @RequestBody Category category){
        int i = categoryService.update(category);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("/deleteCategory")
    public CommonResult deleteCategory(@RequestBody @NotNull Integer id){
        int i = categoryService.delete(id);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
}
