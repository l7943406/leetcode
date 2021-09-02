package P1679K和数对的最大数目;

import java.util.HashMap;
import java.util.Map;

/**hashmap 解法*/
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int m = entry.getKey();
            int n = k - m;
            if(m == n){
                ans += entry.getValue() / 2;
                map.put(m,0);
            }else{
                int l = entry.getValue();
                int r = map.getOrDefault(n,0);
                if(l > 0 && r > 0){
                    int min = Math.min(l,r);
                    ans += min;
                    map.put(m,0);
                    map.put(n,0);
                }
            }
        }
        return ans;

    }


}
/*
给你一个整数数组 nums 和一个整数 k 。

每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。

返回你可以对数组执行的最大操作数。
 */