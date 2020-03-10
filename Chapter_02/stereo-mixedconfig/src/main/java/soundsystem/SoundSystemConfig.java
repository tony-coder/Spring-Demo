package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 更高级别的SoundSystemConfig，在这个类中使用@Import将两个配置类组合到一起
 */
@Configuration
//@Import({CDPlayerConfig.class, CDConfig.class})
@Import(CDPlayerConfig.class)
@ImportResource("classpath:cd-config.xml")  // 加载xml中的配置
public class SoundSystemConfig {

}
