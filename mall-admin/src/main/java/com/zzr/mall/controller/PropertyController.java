package com.zzr.mall.controller;


import com.zzr.mall.model.Property;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@ResponseBody
public class PropertyController {
    @Autowired
    PropertyService propertyService;
    @GetMapping("/selectProperty")
    public CommonResult selectProperty(int CategoryId, int pageSize, int pageNum){
        List<Property> properties = propertyService.selectByPage(CategoryId, pageSize, pageNum);
        if(properties!=null){
            return CommonResult.success(properties);
        }else {
            return CommonResult.failed();
        }
    }
    @PostMapping("addProperty")
    public CommonResult addProperty(@RequestBody Property property){
        int i = propertyService.insert(property);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("deleteProperty")
    public CommonResult deleteProperty(int propertyId){
        int i = propertyService.delete(propertyId);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("updateProperty")
    public CommonResult updateProperty(Property property){
        int i = propertyService.update(property);
        if(i>0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
}
