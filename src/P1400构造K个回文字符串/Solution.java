package P1400构造K个回文字符串;

import java.nio.charset.StandardCharsets;

class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length()){
            return false;
        }else if(k == s.length() || k >= 26){
            return true;
        }
        int[] map = new int[26];

        for(byte c : s.getBytes(StandardCharsets.UTF_8)){
            map[c - 'a'] ++;
        }
        int j = 0;
        for(int i : map){
            if(i % 2 != 0){
                j++;
            }
        }
        return k >= j;
    }
}
/*

给你一个字符串 s和一个整数 k。请你用 s 字符串中 所有字符 构造 k 个非空 回文串。

如果你可以用s中所有字符构造k个回文字符串，那么请你返回 True，否则返回False。

 */