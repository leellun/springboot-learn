package com.example.redissonlock.service.impl;

import com.example.redissonlock.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public String payment(String account, BigDecimal money, String orderId) {
        RLock lock=redissonClient.getLock("lock-"+orderId);
        try {
            lock.lock();
            return "执行完成了";
        } finally {
            lock.unlock();
        }
    }
}
