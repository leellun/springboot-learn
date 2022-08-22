package com.newland.redislock.service.impl;

import com.newland.redislock.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String payment(String account, BigDecimal money, String orderId) {
        boolean lock = false;
        try {
            //redis 核心原理还是setnx orderId TokenLock 命令方式
            lock = redisTemplate.opsForValue().setIfAbsent(orderId, "lock");
            log.info("cancelCouponCode是否获取到锁：" + lock);
            if (lock) {
                redisTemplate.expire(orderId, 1, TimeUnit.MINUTES); //成功设置过期时间
                return "执行完成了";
            } else {
                log.info("cancelCouponCode没有获取到锁，不执行任务!");
                return "锁具被上锁";
            }
        } finally {
            if (lock) {
                redisTemplate.delete(orderId);
                log.info("cancelCouponCode任务结束，释放锁!");
            } else {
                log.info("cancelCouponCode没有获取到锁，无需释放锁!");
            }
        }
    }
}
