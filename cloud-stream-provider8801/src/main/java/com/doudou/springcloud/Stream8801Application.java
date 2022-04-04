package com.doudou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Doudou
 * @date 2022/3/28 - 9:36
 */
@SpringBootApplication
@EnableEurekaClient
public class Stream8801Application {
    public static void main(String[] args) {
        SpringApplication.run(Stream8801Application.class, args);
    }
}
