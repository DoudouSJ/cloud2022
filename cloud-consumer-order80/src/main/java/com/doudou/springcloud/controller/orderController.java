package com.doudou.springcloud.controller;

import com.doudou.springcloud.entities.CommonResult;
import com.doudou.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Doudou
 * @date 2022/3/8 - 8:58
 */
@RestController
public class orderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/consumer/payment")
    public CommonResult<Payment> creat(Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult findPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
    }
}
