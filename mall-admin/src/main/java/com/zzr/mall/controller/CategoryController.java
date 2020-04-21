package com.zzr.mall.controller;

import com.zzr.mall.model.Category;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/selectCategory")
    public CommonResult selectCategory(Integer id, int pageSize, int pageNum){
        List<Category> categories = categoryService.selectByPage(id,pageSize,pageNum);
        if(categories!=null){
            return CommonResult.success(categories);
        }else {
            return CommonResult.failed();
        }
    }
    @PostMapping("/addCategory")
    public CommonResult addCategory(@RequestBody Category category){
        int i = categoryService.insert(category);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("/updateCategory")
    public CommonResult updateCategory(@RequestBody Category category){
        int i = categoryService.update(category);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("/deleteCategory")
    public CommonResult deleteCategory(@RequestBody Integer id){
        int i = categoryService.delete(id);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
}
