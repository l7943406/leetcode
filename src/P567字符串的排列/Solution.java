package P567字符串的排列;

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }
        int[] numS1 = new int[26];
        int[] numS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            numS1[s1.charAt(i) - 'a'] ++;
            numS2[s2.charAt(i) - 'a'] ++;
        }
        if(s1EqualS2(numS1,numS2)){
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            numS2[s2.charAt(i - s1.length()) - 'a'] -- ;
            numS2[s2.charAt(i) - 'a'] ++ ;
            if(s1EqualS2(numS1,numS2)){
                return true;
            }
        }
        return false;
    }
    boolean s1EqualS2(int[] nums1,int[] nums2){
        return Arrays.equals(nums1,nums2);
    }
}