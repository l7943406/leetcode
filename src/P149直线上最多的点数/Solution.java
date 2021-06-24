package P149直线上最多的点数;

import java.util.HashMap;
import java.util.Map;



class Solution {
    /**hash*/
//    public int maxPoints(int[][] points) {
//        int ans = 1;
//        double POSITIVE_INFINITY = 1.0 / 0.0;
//        double NEGATIVE_INFINITY = -1.0 / 0.0;
//        Map<Double,Integer> map = new HashMap<>();
//        for (int i = 0; i < points.length; i++) {
//            map.clear();
//            for (int j = i + 1; j < points.length; j++) {
//                double k = (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
//                if(k == -0){
//                    k = 0;
//                } else if(k == NEGATIVE_INFINITY){
//                    k = POSITIVE_INFINITY;
//                }
//                if(map.containsKey(k)){
//                    map.replace(k,map.get(k) + 1);
//                }else{
//                    map.put(k,2);
//                }
//                ans = Math.max(ans,map.get(k));
//
//            }
//        }
//        return ans;
//    }
    /**朴素*/
    public double POSITIVE_INFINITY = 1.0 / 0.0;
    public double NEGATIVE_INFINITY = -1.0 / 0.0;
    public int maxPoints(int[][] points) {
        int ans = 1;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double k1 = slope(points[i][0],points[i][1],points[j][0],points[j][1]);
                int t = 2;
                for (int l = j + 1; l < points.length; l++) {
                    double k2 = slope(points[j][0],points[j][1],points[l][0],points[l][1]);
                    if(k1 == k2){
                        t++;
                    }
                }
                ans = Math.max(ans,t);
            }
        }
        return ans;
    }
    double slope(int x1,int y1,int x2,int y2){
        double k = (double) (y2 - y1) / (double) (x2 - x1);
        if(k == -0){
            k = 0;
        } else if(k == NEGATIVE_INFINITY){
            k = POSITIVE_INFINITY;
        }
        return k;
    }
}