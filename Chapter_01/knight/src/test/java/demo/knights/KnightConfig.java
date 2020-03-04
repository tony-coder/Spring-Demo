package demo.knights;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.PrintStream;

@Configuration
public class KnightConfig {
    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(stream());
    }

    @Bean
    public FakePrintStream stream() {  // 注意，这边如果换成PrintStream （父类），则无法在注入中被识别
        return new FakePrintStream();
    }

}
