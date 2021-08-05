package 剑指OfferII079所有子集;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    byte[] s;
    public List<List<Integer>> subsets(int[] nums) {
        s = new byte[nums.length];
        double n = Math.pow(2,nums.length);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new LinkedList<>();
            toBinary(i);
            for (int j = 0; j < nums.length; j++) {
                if(s[j] == '1'){
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
    public void toBinary(int num){
        int index = s.length - 1;
        while (num != 0){
            if((num & 1) == 1){
                s[index] = '1';
            }else{
                s[index] = '0';
            }
            index --;
            num >>= 1;
        }
        while (index > -1){
            s[index --] = '0';
        }
    }
}
/*
给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */