package com.example.bootaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author leellun
 * @date 2020/3/5 16:52
 * @desc AOP在spring的执行顺序
 *          1.IOC  2.AOP  3.DI  4.MVC
 *        把代理对象进行了依赖注入，原生对象被保存到了BeanWrapper中
 */
@Aspect
@Slf4j
@Service
public class LogAspect {

    @Pointcut(value="execution(public * com.example.bootaop.service.*.*(..))")
    public void pointCut(){

    }

    /**
     * 方法请求之前处理
     */
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        log.info("前置通知。。。");
    }

    /**
     * 异常通知，以最终返回通知只能共存一个
     */
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex){
        log.info("异常通知。。。");
    }

    /**
     * 有没有异常都会执行
     */
    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint){
        log.info("后置通知。。。");
    }

    /**
     * 正常返回的通知，如果有异常则不执行
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        log.info("最终返回通知。。。");
    }
}
