package com.doudou.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doudou
 * @date 2022/4/4 - 18:15
 */
@RestController
public class NacosController {
    @Value("${server.port}")
    String port;

    @GetMapping("nacos")
    public String echo(){
        return "Hello Nacos DisDiscovery："+port;
    }
}
