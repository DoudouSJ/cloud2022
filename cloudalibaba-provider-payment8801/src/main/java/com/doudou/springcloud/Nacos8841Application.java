package com.doudou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Doudou
 * @date 2022/4/4 - 3:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Nacos8841Application {
    public static void main(String[] args) {
        SpringApplication.run(Nacos8841Application.class, args);
    }
}
