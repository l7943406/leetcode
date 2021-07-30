package P1358包含所有三种字符的子字符串数目;

class Solution {
    public int numberOfSubstrings(String s) {
        int[] map = new int[3];
        for(byte c : s.getBytes()){
            map[c - 'a'] ++;
        }
        return 0;
    }
}
/*

给你一个字符串 s ，它只包含三种字符 a, b 和 c 。

请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。

 */