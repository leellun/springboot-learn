package com.newland.mysqllock.service.impl;

import com.newland.mysqllock.lock.DbLock;
import com.newland.mysqllock.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private DbLock dbLock;

    @Override
    public String payment(String account, BigDecimal money, String orderId) {
        boolean isLock = false;
        try {
            dbLock.lock(orderId);
            isLock = true;
            Thread.sleep(5000);
            log.info("支付流程正常执行成功了" + Thread.currentThread());
            return "执行完成了";
        } catch (Exception e) {
            e.printStackTrace();
            log.error("当前上锁了");
            return "锁具被上锁";
        } finally {
            if (isLock) {
                dbLock.unLock(orderId);
            }
        }
    }
}
