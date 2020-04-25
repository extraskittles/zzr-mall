package com.zzr.mall.controller;


import com.zzr.mall.model.User;
import com.zzr.mall.result.CommonPage;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/selectUser")
    public CommonResult selectUser(@RequestParam(required = true) int id){
        User user = userService.selectUser(id);
        if(user!=null){
            return CommonResult.success(user);
        }else {
            return CommonResult.failed();
        }
    }

    @GetMapping("/selectUsers")
    public CommonResult selectUser(@RequestParam(required = true) int pageNum,@RequestParam(required = true)int pageSize){
        List<User> users = userService.selectUsers(pageNum, pageSize);
        if(users!=null){
            return CommonResult.success(CommonPage.getPage(users));
        }else {
            return CommonResult.failed();
        }
    }
}
