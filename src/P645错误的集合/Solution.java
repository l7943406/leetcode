package P645错误的集合;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        int[] ans = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if(map.get(i) == null){
                ans[1] = i;
                if(ans[0] != 0 && ans[1]!= 0){
                    return ans;
                }
            }else if(map.get(i) == 2){
                ans[0] = i;
                if(ans[0] != 0 && ans[1] != 0){
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(1^2^3^4^5);
        System.out.println(1^2^2^4^5);
    }
}
/*
* 懵逼位运算
* class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i = 0; i < n; i++){
            xor ^= (i + 1) ^ nums[i];
        }
        int rightOne = xor & - xor;

        int a = 0;
        for(int i = 0; i < n; i++){
            if(((i + 1) & rightOne) != 0){
                a ^= (i + 1);
            }
            if((nums[i] & rightOne) != 0){
                a ^= nums[i];
            }
        }

        for(int num : nums){
            if(num == a){
                return new int[]{a, a ^ xor};
            }
        }
        return new int[]{a ^ xor, a};
    }
}

作者：edelweisskoko
链接：https://leetcode-cn.com/problems/set-mismatch/solution/645-cuo-wu-de-ji-he-wei-yun-suan-fen-zu-k5i5n/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/