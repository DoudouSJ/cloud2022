package com.doudou.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Doudou
 * @date 2022/4/4 - 18:41
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${service-url.nacos-payment-service}")
    private String paymentUrl;

    @GetMapping("nacos/consumer")
    public String echo(){
        return restTemplate.getForObject(paymentUrl+"/nacos", String.class);
    }

}
