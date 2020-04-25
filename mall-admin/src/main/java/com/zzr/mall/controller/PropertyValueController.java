package com.zzr.mall.controller;
import com.zzr.mall.dto.PropertyValueUpdateParam;
import com.zzr.mall.model.PropertyValue;
import com.zzr.mall.result.CommonPage;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.PropertyValueService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@ResponseBody
@Api(tags = "商品属性值管理")
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @GetMapping("/selectPropertyValues")
    public CommonResult selectByProductId(int productId) {
        List<com.zzr.mall.model.PropertyValue> propertyValues = propertyValueService.selectByProductId(productId);
        if (propertyValues != null) {
            return CommonResult.success(CommonPage.getPage(propertyValues));
        } else {
            return CommonResult.failed();
        }
    }
    @PostMapping("/updateProValue")
    public CommonResult updateProValue(@RequestBody @Validated PropertyValueUpdateParam param){
        int i = propertyValueService.update(param);
        if (i>0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }
}
