package com.doudou.springcloud.service;

import com.doudou.springcloud.service.handler.HystrixHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Doudou
 * @date 2022/3/22 - 11:31
 */
@Service
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE", fallback = HystrixHandler.class)
public interface HystrixService {
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);
}
