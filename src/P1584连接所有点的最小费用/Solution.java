package P1584连接所有点的最小费用;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int result = 0;
        int min = 0;
        for (int i = 1; i < points.length; i++) {
            min = 0;
            for (int j = 0; j < i; j++) {
                int l = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                if(l < min){
                    min = l;
                }
            }
            result += min;
        }
        return result;
    }

}