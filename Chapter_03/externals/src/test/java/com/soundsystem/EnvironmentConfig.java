package com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import static org.junit.Assert.*;

/**
 * 在Spring中，处理外部值的最简单方式就是声明属性源并通过Spring的Environment来检索属性
 * 使用外部属性来装配BlankDisc
 */

@Configuration
@PropertySource("classpath:/com/soundsystem/app.properties")  // 声明属性源
public class EnvironmentConfig {
    @Autowired
    Environment env;  // 属性文件app.properties将加载到env

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(env.getProperty("disc.title"),
                env.getProperty("disc.artist"));  // 检索属性值
    }
}