package com.scorpios.account.controller;

import com.scorpios.account.service.AccountService;
import com.scorpios.common.util.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    // 扣减账户余额
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        System.out.println("money" + money);
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功！");
    }

}
