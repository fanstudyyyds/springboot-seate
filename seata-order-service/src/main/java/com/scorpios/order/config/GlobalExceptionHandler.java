package com.scorpios.order.config;

import com.scorpios.common.util.CommonResult;
import feign.RetryableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RetryableException.class)
    @ResponseBody
    public CommonResult retryableException(Exception e) {
        System.out.println("全局异常捕获：" + e);
        //例如   全局异常捕获：java.lang.ArithmeticException: / by zero
        return new CommonResult(500, "订单创建超时");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult exceptionHandler(Exception e) {
        System.out.println("全局异常捕获：" + e);
        //例如   全局异常捕获：java.lang.ArithmeticException: / by zero
        return new CommonResult(500, "订单创建异常");
    }
}
