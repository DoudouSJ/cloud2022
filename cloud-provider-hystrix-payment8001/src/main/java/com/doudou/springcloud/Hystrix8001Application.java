package com.doudou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author Doudou
 * @date 2022/3/21 - 23:29
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class Hystrix8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix8001Application.class, args);
    }
}
