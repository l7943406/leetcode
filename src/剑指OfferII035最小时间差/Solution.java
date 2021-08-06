package 剑指OfferII035最小时间差;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        int i = 0;
        for(String s : timePoints){
            times[i++] += 600 * s.charAt(0)  + 60 * s.charAt(1)  + 10 * s.charAt(3) + s.charAt(4)  - 671 * '0' ;
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < times.length; j++) {
            int t = times[j] - times[j - 1];
            if(t < min){
                min = t;
            }
        }
        int er = times[0] + 24 * 60 - times[times.length - 1];
        return Math.min(er,min);
    }
}
/*

给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

 */