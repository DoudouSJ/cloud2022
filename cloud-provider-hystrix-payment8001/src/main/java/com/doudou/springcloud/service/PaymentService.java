package com.doudou.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @author Doudou
 * @date 2022/3/21 - 23:30
 */
@Service
public class PaymentService {

    public String payment_ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+"--payment_ok--"+id+"O(∩_∩)O哈哈~";
    }

    @HystrixCommand(
        fallbackMethod = "payment_timeoutHandler",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
        }
    )
    public String payment_timeout(Integer id){
        try {
            Thread.sleep(1000*id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"--payment_timeout--O(∩_∩)O哈哈~延时："+id;
    }

    public String payment_timeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"--payment_timeoutHandler--o(╥﹏╥)o延时："+id;
    }

    @HystrixCommand(
            fallbackMethod = "payment_fusingHandler",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 是否打开断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 请求次数
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  // 失败率达到多少开启断路器
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  // 快照时间窗
            }
    )
    public String payment_fusing (Integer id){
        if (id < 0){
            throw new RuntimeException("不能为负数");
        }
        return "正常执行--线程池："+Thread.currentThread().getName()+"--payment_fusing--O(∩_∩)O";
    }

    public String payment_fusingHandler(Integer id){
        return "错误执行--线程池："+Thread.currentThread().getName()+"--payment_fusing--o(╥﹏╥)o";
    }

}
