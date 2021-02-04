package P49字母异位词分组;

import java.util.*;

class Solution {
    List<List<String>> ans;
    Map<String,List<String>> map;
    public List<List<String>> groupAnagrams(String[] strs) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        for (String str : strs) {
            solve(str);
        }
        return ans;
    }
    public void solve(String s){
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i)-'a']++;
        }
        String key = Arrays.toString(num);
       if(map.containsKey(key)){
           map.get(key).add(s);
        }else{
           List<String> list = new ArrayList<>();
           list.add(s);
           ans.add(list);
           map.put(key,list);
        }
    }
}