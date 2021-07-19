package 面试题10_02变位词组;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    int[] prime = new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103};
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> map = new HashMap<>();
        List<List<String>> ans = new LinkedList<>();
        for(String s : strs){
            int key = get(s);
            if(!map.containsKey(key)){
                List<String> list = new LinkedList<>();
                ans.add(list);
                map.put(key,list);
            }
            map.get(key).add(s);
        }
        return ans;
    }
    public int get(String s){
        int ans = 1;
        for(byte i : s.getBytes()){
            ans *= prime[i - 'a'];
        }
        return ans;
    }

}