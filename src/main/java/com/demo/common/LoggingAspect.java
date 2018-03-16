package com.demo.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by zhengw on 2018/3/14.
 */
@Component
@Aspect
public class LoggingAspect {

    /**
     * 定义一个切入点.
     * 解释下：
     *
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 定义在web包或者子包
     * ~ 第三个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */
    @org.aspectj.lang.annotation.Around("execution(* com.demo.service.impl.service..*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            String msg="【调用方法】" + joinPoint + "t【耗时】 : " + (end - start) + " ms";
            System.out.println(msg);
            return result;

        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            String msg="【调用方法】 " + joinPoint + "\t【耗时】 : " + (end - start) + " ms with com.demo.common.exception : " + e.getMessage();
            System.out.println(msg);
            throw e;
        }

    }



}
