package com.doudou.springcloud.service.handler;

import com.doudou.springcloud.service.HystrixService;
import org.springframework.stereotype.Component;

/**
 * @author Doudou
 * @date 2022/3/22 - 11:34
 */
@Component
public class HystrixHandler implements HystrixService {
    @Override
    public String payment_timeout(Integer id) {
        return "HystrixHandler_payment_timeout:::通配服务降级";
    }
}
