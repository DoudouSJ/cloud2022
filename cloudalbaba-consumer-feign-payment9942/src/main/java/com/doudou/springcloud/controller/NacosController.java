package com.doudou.springcloud.controller;

import com.doudou.springcloud.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doudou
 * @date 2022/4/4 - 19:44
 */
@RestController
public class NacosController {

    @Autowired
    FeignService feignService;

    @GetMapping("nacos/consumer")
    public String echo(){
        return "1";
    }
}
