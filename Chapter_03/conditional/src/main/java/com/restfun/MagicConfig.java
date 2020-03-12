package com.restfun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagicConfig {
    @Bean
    @Conditional(MagicExistsCondition.class)  //条件化地创建bean 根据MagicExistsCondition判断
    public MagicBean magicBean() {
        return new MagicBean();
    }
}
