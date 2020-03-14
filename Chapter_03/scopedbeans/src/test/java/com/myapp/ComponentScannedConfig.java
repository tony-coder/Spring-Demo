package com.myapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 指定不适合组件扫描的类型 将标有@Configuration注解的类排除在外不会加载到容器中来
// 因为ExplicitConfig需要单独测试，所以不应该被扫描到
@ComponentScan(excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
public class ComponentScannedConfig {

}
