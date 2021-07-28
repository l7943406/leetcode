package P1784检查二进制字符串字段;

class Solution {
    public boolean checkOnesSegment(String s) {
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                break;
            }
        }
        for (; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                break;
            }
        }
        for (; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                return false;
            }
        }
        return true;
    }
}
/*

给你一个二进制字符串 s ，该字符串 不含前导零 。

如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。

 */