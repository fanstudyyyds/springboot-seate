package com.scorpios.order.controller;


import com.scorpios.common.domain.Order;
import com.scorpios.common.util.CommonResult;
import com.scorpios.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class OrderController{

    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order){
        BigDecimal bigDecimal = new BigDecimal("100");
        order=new Order(1L,1L,1L,1,bigDecimal,0);
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }


}

