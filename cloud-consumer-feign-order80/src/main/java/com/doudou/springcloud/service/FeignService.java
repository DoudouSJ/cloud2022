package com.doudou.springcloud.service;

import com.doudou.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Doudou
 * @date 2022/3/21 - 9:07
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignService {

    @GetMapping("/payment/{id}")
    public CommonResult insertPayment(@PathVariable("id") Long id);

}
