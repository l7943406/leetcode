package 剑指OfferII033变位词组;


import java.util.*;

class Solution {
    List<List<String>> ans;
    Map<String,Integer> map;
    public List<List<String>> groupAnagrams(String[] strs) {
        ans = new ArrayList<>(strs.length);
        map = new HashMap<>(strs.length);
        for(String str : strs){
            add(str);
        }
        return ans;
    }
    private void add(String str){
        byte[] nums = new byte[26];
        for(byte c : str.getBytes()){
            nums[c - 'a'] ++;
        }
        String key = new String(nums);
        Integer index = map.get(key);
        if(index != null){
            ans.get(index).add(str);
        }else{
            List<String> list = new LinkedList<>();
            list.add(str);
            ans.add(list);
            map.put(key,ans.size() - 1);
        }
    }
}
/*

给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。

注意：若两个字符串中每个字符出现的次数都相同且字符顺序不完全相同，则称它们互为变位词。


 */