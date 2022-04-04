package com.doudou.springcloud.controller;

import com.doudou.springcloud.entities.CommonResult;
import com.doudou.springcloud.entities.Payment;
import com.doudou.springcloud.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doudou
 * @date 2022/3/21 - 9:13
 */
@RestController
public class orderController {

    @Autowired
    FeignService feignService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> findPayment(@PathVariable("id") Long id){
        CommonResult commonResult = feignService.insertPayment(id);
        return commonResult;
    }

}
