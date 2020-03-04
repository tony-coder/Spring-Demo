package demo.knights.config;

import demo.knights.BraveKnight;
import demo.knights.Knight;
import demo.knights.Quest;
import demo.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring提供了基于Java的配置,可作为XML的替代方案
 */
@Configuration
public class KnightConfig {
    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
