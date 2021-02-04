package P1637两点之间不包含任何点的最宽垂直面积;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, new myCmp());
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans,points[i][0] - points[i-1][0]);
        }
        return ans;
    }
    static class myCmp implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}