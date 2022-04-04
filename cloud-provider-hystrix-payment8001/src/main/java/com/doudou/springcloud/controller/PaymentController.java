package com.doudou.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.doudou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doudou
 * @date 2022/3/21 - 23:35
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String ok = paymentService.payment_ok(id);
        log.info(ok);
        return ok;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        String timeout = paymentService.payment_timeout(id);
        log.info(timeout);
        return timeout;
    }

    @GetMapping("/payment/hystrix/fusing/{id}")
    public String payment_fusing(@PathVariable("id") Integer id){
        String timeout = paymentService.payment_fusing(id);
        String s = IdUtil.simpleUUID();
        log.info(timeout+s);
        return timeout+"\n"+s;
    }
}
