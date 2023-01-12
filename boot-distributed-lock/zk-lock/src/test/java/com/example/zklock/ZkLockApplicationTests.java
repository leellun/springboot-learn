package com.example.zklock;

import com.example.zklock.service.IPaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@SpringBootTest
class ZkLockApplicationTests {

    @Autowired
    private IPaymentService paymentService;
    @Test
    void contextLoads() {
        paymentService.payment("12",new BigDecimal(0),"111");
    }

}
