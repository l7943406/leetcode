package P1347制造字母异位词的最小步骤数;

class Solution {
    public int minSteps(String s, String t) {
        int[] map = new int[26];
        for(byte c : s.getBytes()){
            map[c - 'a'] ++;
        }
        for(byte c : t.getBytes()){
            map[c - 'a'] --;
        }
        int ans = 0;
        for(int i : map){
            if(i > 0){
                ans += i;
            }
        }
        return ans;
    }
}
/*
给你两个长度相等的字符串s 和 t。每一个步骤中，你可以选择将t中的 任一字符 替换为 另一个字符。

返回使t成为s的字母异位词的最小步骤数。

字母异位词 指字母相同，但排列不同（也可能相同）的字符串。
*/