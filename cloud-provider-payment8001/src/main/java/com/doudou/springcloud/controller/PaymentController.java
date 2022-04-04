package com.doudou.springcloud.controller;

import com.doudou.springcloud.entities.CommonResult;
import com.doudou.springcloud.entities.Payment;
import com.doudou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Doudou
 * @date 2022/3/7 - 23:04
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;
    @Autowired
    DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String port;

    @PostMapping("/payment")
    public CommonResult insertPayment(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if (result > 0){
            return new CommonResult(200, "插入成功", result);
        } else {
            return new CommonResult(200, "插入失败");
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult insertPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.findPayment(id);
        log.info("插入结果" + payment);
        if (payment != null){
            return new CommonResult(200, "查询成功"+port, payment);
        } else {
            return new CommonResult(200, "查询失败"+port);
        }
    }

    @GetMapping("/payment/local/{id}")
    public String findPayment(@PathVariable("id") Long id){
        log.info("findPayment" + port + id);
        return port+"--"+id;
    }


    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service--{}", service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("instance-ServiceId{}---Host{}---Port{}---InstanceId{}---Uri{}"
                        ,instance.getServiceId(),instance.getHost(),instance.getPort(),instance.getInstanceId(),instance.getUri());
            }
        }
        return this.discoveryClient;
    }

}
