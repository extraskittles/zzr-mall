package com.zzr.mall.exceptionHandler;

import com.zzr.mall.result.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public CommonResult error2(Exception e){
        return CommonResult.failed("删除或更新的记录有外键约束");
    }
}
