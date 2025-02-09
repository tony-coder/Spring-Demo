package com.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  // 启用AspectJ自动代理
@ComponentScan
public class ConcertConfig {
    /*@Bean
    public Audience audience() {  // 声明 Audience bean
        return new Audience();
    }*/

    @Bean
    public Audience2 audience2() {
        return new Audience2();
    }

    @Bean
    public Player player() {
        return new Player();
    }
}
