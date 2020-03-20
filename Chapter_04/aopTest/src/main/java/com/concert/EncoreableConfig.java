package com.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  // 启用AspectJ自动代理
public class EncoreableConfig {
    @Bean
    public Player player() {
        return new Player();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {  // 需要注册 EncoreableIntroducer bean
        return new EncoreableIntroducer();
    }
}
