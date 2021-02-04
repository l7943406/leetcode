package P424替换后的最长重复字符;

import java.util.Arrays;
import java.util.OptionalInt;

class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null){
            return 0;
        }
        int ans = 0, i = 0 , j = 1;
        int[] num = new int[26];
        num[s.charAt(0) - 'A'] ++ ;
        while (i < j && j < s.length()){
            int max = Arrays.stream(num).max().getAsInt();
            int sum = Arrays.stream(num).sum();
            if(sum - max <= k){
                num[s.charAt(j) - 'A'] ++ ;
                j++;
                ans = Math.max(ans, max + k);
            }else{
                num[s.charAt(i) - 'A'] --;
                i++;
            }
        }
        return Math.min(ans,s.length());
    }
}