package com.zzr.mall.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Api(tags = "测试")
public class TestController2 {
    @GetMapping("aa")
    public String aa(){
        return "aa";
    }
}
