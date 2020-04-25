package com.zzr.mall.controller;


import com.zzr.mall.dto.PropertyAddParam;
import com.zzr.mall.dto.PropertyUpdateParam;
import com.zzr.mall.model.Property;
import com.zzr.mall.result.CommonPage;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.PropertyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@Controller
@ResponseBody
@Api(tags = "商品属性管理")
public class PropertyController {
    @Autowired
    PropertyService propertyService;
    @GetMapping("/selectProperty")
    public CommonResult selectProperty(@RequestParam(required = true) int categoryId, @RequestParam(required = true)int pageNum, @RequestParam(required = true)int pageSize){
        List<Property> properties = propertyService.selectProperty(categoryId, pageNum, pageSize);
        if(properties!=null){
            return CommonResult.success(CommonPage.getPage(properties));
        }else {
            return CommonResult.failed();
        }
    }
    @GetMapping("/selectOne")
    public CommonResult selectOne(@RequestParam(required = true) int propertyId){
        Property property = propertyService.selectOne(propertyId);
        if(property!=null){
            return CommonResult.success(property);
        }else {
            return CommonResult.failed();
        }
    }
    @PostMapping("addProperty")
    public CommonResult addProperty(@RequestBody @Validated PropertyAddParam param){
        int i = propertyService.insert(param);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("deleteProperty")
    public CommonResult deleteProperty(@RequestBody @NotNull int propertyId){
        int i = propertyService.delete(propertyId);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("updateProperty")
    public CommonResult updateProperty(@RequestBody @Validated PropertyUpdateParam param){
        int i = propertyService.update(param);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
}
