package com.zzr.mall.controller;

import com.zzr.mall.dao.PropertyValueDao;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Api(tags = "测试")
public class TestController2 {
    @Autowired
    PropertyValueDao propertyValueDao;
    @GetMapping("aa")
    public String aa(){
        return "aa";
    }


}
