package com.doudou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Doudou
 * @date 2022/4/4 - 18:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Consumer9941Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer9941Application.class,args);
    }
}
