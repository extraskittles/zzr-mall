package com.zzr.mall.controller;


import com.zzr.mall.model.User;
import com.zzr.mall.result.CommonResult;
import com.zzr.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/selectUser")
    public CommonResult selectUser(int id){
        User user = userService.selectUser(id);
        if(user!=null){
            return CommonResult.success(user);
        }else {
            return CommonResult.failed();
        }
    }

}
