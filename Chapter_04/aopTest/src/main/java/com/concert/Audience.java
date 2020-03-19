package com.concert;

import org.aspectj.lang.annotation.*;

/**
 * 观看演出的切面
 */

@Aspect
public class Audience {
    // 使用@Pointcut注解声明频繁使用的切点表达式
    @Pointcut("execution(* *.concert.Performance.perform(..))")
    public void performance() {
    }

    //@Before("execution(* *.concert.Performance.perform(..))")  // 表演之前
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    //@Before("execution(* com.concert.Performance.perform(..))")  // 表演之前
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    //@AfterReturning("execution(* com.concert.Performance.perform(..))")  // 表演之前
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");  // 表演之后
    }

    //@AfterThrowing("execution(* com.concert.Performance.perform(..))")  // 表演失败之后
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
