package com.doudou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Doudou
 * @date 2022/3/28 - 23:55
 */
@SpringBootApplication
@EnableEurekaClient
public class Stream8802Application {
    public static void main(String[] args) {
        SpringApplication.run(Stream8802Application.class, args);
    }
}
