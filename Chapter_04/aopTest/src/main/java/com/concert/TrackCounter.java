package com.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * 通知playTrack()方法的一个切面
 */

@Aspect
public class TrackCounter {
    private Map<Integer, Integer> trackCounts = new HashMap<>();

    // 使用@Pointcut注解定义命名的切点
    @Pointcut("execution(* com.concert.CompactDisc.playTrack(int))" +
            "&& args(trackNumber)")  // 通知playTrack()方法
    // args(trackNumber)限定符，它表明传递给playTrack()方法的int类型参数也会传递到通知中去。参数的名称trackNumber也与切点方法签名中的参数相匹配
    public void trackPlayed(int trackNumber) {  // 切点方法签名
    }

    // 使用@Before将一个方法声明为前置通知。但是这里的不同点在于切点还声明了要提供给通知方法的参数
    @Before("trackPlayed(trackNumber)")
    public void countPlayed(int trackNumber) {  // 在播放前，为该磁道计数
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }

}
