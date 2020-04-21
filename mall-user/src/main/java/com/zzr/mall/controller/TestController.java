package com.zzr.mall.controller;

import com.zzr.mall.util.TestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
    @GetMapping("/test")
    public String test(){
        String test = TestUtil.test();
        return test;
    }

    public static void main(String[] args) {
    }
}
