package P556下一个更大元素III;

import java.util.Arrays;

class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        byte[] newBytes = s.getBytes();
        int index = solve(newBytes);
        if(index == -1){
            return -1;
        }
        Arrays.sort(newBytes,index + 1,newBytes.length);

        String newS = new String(newBytes);

        if(s.equals(newS)){
            return -1;
        }
        long ans = Long.parseLong(newS);
        if(ans > Integer.MAX_VALUE){
            return -1;
        }
        return (int) ans;


    }
    private int solve(byte[] s){
        for (int i = s.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length; j++) {
                if(s[i] < s[j]){
                    int minIndex = j;
                    for (int k = j + 1; k < s.length; k++) {
                        if(s[i] < s[k] && s[k] < s[minIndex]){
                            minIndex = k;
                        }
                    }
                    byte c = s[i];
                    s[i] = s[minIndex];
                    s[minIndex] = c;
                    return i;
                }
            }
        }
        return -1;
    }





}
/*
给你一个正整数n ，请你找出符合条件的最小整数，其由重新排列 n中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。

注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 */