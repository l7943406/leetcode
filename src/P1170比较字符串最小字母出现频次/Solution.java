package P1170比较字符串最小字母出现频次;

import java.util.Arrays;

class Solution {
    static int[] map = new int[26];
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] map = new int[12];
        for(String word : words){
            map[f(word)] ++;
        }
        for (int i = map.length - 2; i >= 0; i--) {
            map[i] += map[i + 1];
        }

        int[] ans = new int[queries.length];
        int index = 0;
        for(String query : queries){
            ans[index++] = map[f(query) + 1];
        }
        return ans;
    }
    public static int f(String s){
        Arrays.fill(map,0);
        for(byte c : s.getBytes()){
            map[c - 'a'] ++;
        }
        for(int i : map){
            if(i > 0){
                return i;
            }
        }
        return 0;
    }
}
/*
定义一个函数f(s)，统计s 中（按字典序比较）最小字母的出现频次 ，其中 s是一个非空字符串。

例如，若s = "dcce"，那么f(s) = 2，因为字典序最小字母是"c"，它出现了2 次。

现在，给你两个字符串数组待查表queries和词汇表words 。对于每次查询queries[i] ，需统计 words 中满足f(queries[i])< f(W)的 词的数目 ，W 表示词汇表words中的每个词。

请你返回一个整数数组answer作为答案，其中每个answer[i]是第 i 次查询的结果。

 */