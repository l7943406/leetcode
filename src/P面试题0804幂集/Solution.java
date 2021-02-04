package P面试题0804幂集;

import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = getBinary(nums.length);
        for (int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(i);
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '1'){
                    list.add(nums[nums.length - s.length() + j]);
                }
            }
            ans.add(list);
        }

        return ans;
    }
    int getBinary(int length){
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += Math.pow(2,i);
        }
        return result + 1;
    }

}