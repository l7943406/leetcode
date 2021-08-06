package 剑指OfferII005单词长度的最大乘积;

import java.util.Arrays;

class Solution {
    public int maxProduct(String[] words) {
        int[] nums = new int[words.length];
        int i = 0;
        for(String word : words){
            for(byte c : word.getBytes()){
                nums[i] |= (1 << c - 'a');
            }
            i++;
        }
        int ans = 0;
        for (i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if((nums[i] & nums[j]) == 0){
                    int t = words[i].length() * words[j].length();
                    if(t > ans){
                        ans = t;
                    }
                }
            }
        }
        return ans;
    }

}