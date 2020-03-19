package com.concert;

import org.springframework.stereotype.Component;

@Component
public class Player implements Performance {
    @Override
    public void perform() {
        System.out.println("playing...");
    }
}
