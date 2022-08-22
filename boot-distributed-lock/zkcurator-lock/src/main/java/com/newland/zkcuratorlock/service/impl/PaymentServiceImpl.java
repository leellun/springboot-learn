package com.newland.zkcuratorlock.service.impl;

import com.newland.zkcuratorlock.config.DistributedLockByCurator;
import com.newland.zkcuratorlock.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private DistributedLockByCurator distributedLockByCurator;

    @Override
    public String payment(String account, BigDecimal money, String orderId) {
        boolean lock = false;
        try {
            lock = distributedLockByCurator.acquireDistributedLock(orderId);
            log.info("cancelCouponCode是否获取到锁：" + lock);
            return "执行完成了";
        } finally {
            if (lock) {
                distributedLockByCurator.releaseDistributedLock(orderId);
                log.info("cancelCouponCode任务结束，释放锁!");
            } else {
                log.info("cancelCouponCode没有获取到锁，无需释放锁!");
            }
        }
    }
}
