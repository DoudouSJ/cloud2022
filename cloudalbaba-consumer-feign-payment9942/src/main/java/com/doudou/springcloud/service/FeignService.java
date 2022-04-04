package com.doudou.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Doudou
 * @date 2022/4/4 - 19:43
 */
@Service
@FeignClient(value = "cloudalibaba-provider-payment")
public interface FeignService {

    @GetMapping("nacos")
    public String echo();

}
