package P1814统计一个数组中好对子的数目;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countNicePairs(int[] nums) {
        long ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = res(num);
            map.put(key,map.getOrDefault(key,0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            long sum = entry.getValue();
            ans += sum * (sum - 1) / 2;
            ans %= 1000000007;
        }

        return (int)(ans % 1000000007);
    }

    public int res(int num){
        StringBuilder s = new StringBuilder();
        return num - Integer.parseInt(s.append(num).reverse().toString());
    }
}
