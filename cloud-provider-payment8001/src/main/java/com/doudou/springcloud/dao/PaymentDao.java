package com.doudou.springcloud.dao;

import com.doudou.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author Doudou
 * @date 2022/3/7 - 22:42
 */
@Component
public interface PaymentDao {

    public int create(Payment payment);

    public Payment findPayment(@Param("id") Long id);

}
