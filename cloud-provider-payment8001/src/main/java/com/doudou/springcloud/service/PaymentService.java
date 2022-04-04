package com.doudou.springcloud.service;

import com.doudou.springcloud.dao.PaymentDao;
import com.doudou.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Doudou
 * @date 2022/3/7 - 23:02
 */
@Service
public class PaymentService {

    @Autowired
    PaymentDao paymentDao;

    public int create(Payment payment){
        int id = paymentDao.create(payment);
        return id;
    }

    public Payment findPayment(Long id){
        Payment payment = paymentDao.findPayment(id);
        return payment;
    }

}
