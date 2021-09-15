package P56合并区间;

import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        int top = 0;
        Arrays.sort(intervals,(a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int l = -1;
        int r = -1;
        for(int[] interval : intervals){
            if(l == -1 && r == -1){
                l = interval[0];
                r = interval[1];
                continue;
            }
            if(r >= interval[0]){
                if(interval[1] > r){
                    r = interval[1];
                }
            }else{
                intervals[top][0] = l;
                intervals[top][1] = r;
                top++;
                l = interval[0];
                r = interval[1];
            }
        }

        if(l != -1 && r != -1){
            intervals[top][0] = l;
            intervals[top][1] = r;
            top++;
        }
        return Arrays.copyOf(intervals, top);
    }
}
/*
7010
7050
7020
*/