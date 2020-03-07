package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {
    // @Bean注解会告诉Spring这个方法将会返回一个对象，该对象要注册为Spring应用上下文中的bean。方法体中包含最终产生bean实例的逻辑
    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    /*@Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }*/

    // 当Spring调用cdPlayer()创建CDPlayerbean的时候，它会自动装配一个CompactDisc到配置方法之中，然后方法体就可以按照合适的方式来使用它
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}
