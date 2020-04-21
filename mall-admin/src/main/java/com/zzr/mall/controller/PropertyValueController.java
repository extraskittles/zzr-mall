package com.zzr.mall.controller;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.PropertyValueService;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@ResponseBody
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @GetMapping("/selectPropertyValues")
    public CommonResult selectByProductId(int productId) {
        List<com.zzr.mall.model.PropertyValue> propertyValues = propertyValueService.selectByProductId(productId);
        if (propertyValues != null) {
            return CommonResult.success(propertyValues);
        } else {
            return CommonResult.failed();
        }
    }
    @PostMapping("/updateProValue")
    public CommonResult updateProValue(PropertyValue propertyValue){
       /* int update = propertyValueService.update(propertyValue);
        if (i>0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }*/
       return null;
    }
}
