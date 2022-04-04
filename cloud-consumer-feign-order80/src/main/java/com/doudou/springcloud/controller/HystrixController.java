package com.doudou.springcloud.controller;

import com.doudou.springcloud.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doudou
 * @date 2022/3/22 - 11:31
 */
@RestController
@DefaultProperties(defaultFallback = "payment_defaultHandler")
public class HystrixController {

    @Autowired
    HystrixService hystrixService;

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(
//            fallbackMethod = "payment_timeoutHandler",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//            }
//    )
    @HystrixCommand
    public String payment_timeout(@PathVariable("id") Integer id){
        String timeout = hystrixService.payment_timeout(id);
        return timeout;
    }

    public String payment_timeoutHandler(Integer id){
        return "HystrixController---payment_timeoutHandler";
    }

    public String payment_defaultHandler(Integer id){
        return "HystrixController---payment_defaultHandler---全局降级方法";
    }
}
