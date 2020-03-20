package com.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置TrackCount记录每个磁道播放的次数
 */

@Configuration
@EnableAspectJAutoProxy  // 启用AspectJ自动代理
public class TrackCounterConfig {
    @Bean
    public CompactDisc stgPeppers() {  // CompactDisc bean
        List<String> tracks = new ArrayList<>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help from My Friends");
        tracks.add("Lucy in the Sky with Diamonds");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");
        tracks.add("She's Leaving Home");
        tracks.add("Being for the Benefit of Mr. Kite!");
        tracks.add("Within You Without You");
        tracks.add("When I'm Sixty-Four");
        tracks.add("Lovely Rita");
        tracks.add("Good Morning Good Morning");
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band (Reprise)");
        tracks.add("A Day in the Life");

        BlankDisc cd = new BlankDisc("Sgt. Pepper's Lonely Hearts Club Band", "The Beatles", tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {  // TrackCounter bean
        return new TrackCounter();
    }
}
