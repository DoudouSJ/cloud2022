package com.doudou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Doudou
 * @date 2022/3/16 - 8:51
 */
@EnableEurekaServer
@SpringBootApplication
public class Eureka7002Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7002Application.class, args);
    }
}
