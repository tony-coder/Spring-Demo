package demo.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan注解能够在Spring中启用组件扫描、
// 如果没有其他配置的话，@ComponentScan默认会扫描与配置类相同的包，查找带有@Component注解的类
@ComponentScan(basePackages = "demo.soundsystem")  // 指定基础包 （类型不安全）
//@ComponentScan(basePackages = {"demo.soundsystem","demo.video"})  // 设置多个基础包
//@ComponentScan(basePackageClasses = {CDPlayer.class,DVDPlay.class})  //
public class CDPlayerConfig {
}
