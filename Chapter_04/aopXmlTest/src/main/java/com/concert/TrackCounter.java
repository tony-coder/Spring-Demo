package com.concert;

import java.util.HashMap;
import java.util.Map;

/**
 * 通知playTrack()方法的一个切面
 */

public class TrackCounter {
    private Map<Integer, Integer> trackCounts = new HashMap<>();

    // 要声明为前置通知的方法
    public void countPlayed(int trackNumber) {  // 在播放前，为该磁道计数
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}
