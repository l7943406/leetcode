package P916单词子集;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] hash = new int[26];
        for(String word : words2){
            int[] map = new int[26];
            for(byte c : word.getBytes()){
                map[c - 'a']++ ;
            }
            for (int i = 0; i < map.length; i++) {
                hash[i] = Math.max(hash[i], map[i]);
            }
        }
        for(String word : words1){
            int[] map = new int[26];
            for(byte c : word.getBytes()){
                map[c - 'a']++ ;
            }
            boolean flag = true;
            for (int i = 0; i < map.length; i++) {
                if(map[i] < hash[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans.add(word);
            }
        }


        return ans;
    }
}