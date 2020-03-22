package com.concert;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 观看演出的切面
 */

public class Audience {
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            // 表演之前
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();  // 执行被通知的方法
            // 表演成功之后
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable throwable) {
            // 表演失败之后
            System.out.println("Demanding a refund");
        }
    }

    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    public void takeSeats() {
        System.out.println("Taking seats");
    }

    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
