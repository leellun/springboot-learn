package com.example.zklock.service.impl;

import com.example.zklock.config.ZooKeeperSession;
import com.example.zklock.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private ZooKeeperSession zooKeeperSession;

    @Override
    public String payment(String account, BigDecimal money, String orderId) {
        boolean lock = false;
        try {
            lock = zooKeeperSession.acquireDistributedLock(orderId);
            log.info("cancelCouponCode是否获取到锁：" + lock);
            return "执行完成了";
        } finally {
            if (lock) {
                zooKeeperSession.releaseDistributedLock(orderId);
                log.info("cancelCouponCode任务结束，释放锁!");
            } else {
                log.info("cancelCouponCode没有获取到锁，无需释放锁!");
            }
        }
    }
}
