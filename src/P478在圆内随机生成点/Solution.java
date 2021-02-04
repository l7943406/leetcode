package P478在圆内随机生成点;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    double radius;
    double x_center;
    double y_center;
    Map<Double,Integer> map1;
    Map<Double,Integer> map2;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    public double[] randPoint() {
        double[] ans = new double[2];
        double random1 = new SecureRandom().nextDouble();
        double random2 =  new SecureRandom().nextDouble();
        ans[0] = random1 % (radius * 2) - radius + x_center;
        double y_radius = Math.sqrt(radius * radius - (ans[0] - x_center) * (ans[0] - x_center));
        ans[1] = random2 % (y_radius * 2) - y_radius + y_center;
        if(map1.containsKey(ans[0])){
            return randPoint();
        }
        if(map2.containsKey(ans[1])){
            return randPoint();
        }

        map1.put(ans[0],1);
        map2.put(ans[1],1);
        if(Math.sqrt((ans[0]-x_center) * (ans[0] - x_center) + (ans[1] - y_center) * (ans[1] - y_center)) > radius){
            return randPoint();
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */