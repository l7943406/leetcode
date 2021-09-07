package P1221分割平衡字符串;

class Solution {
    public int balancedStringSplit(String s) {
        int l = 0;
        int r = 0;
        int ans = 0;
        for(byte c : s.getBytes()){
            if(c == 'L'){
                l++;
            }else{
                r++;
            }
            if(l != 0 && r == l){
                r = 0;
                l = 0;
                ans ++;
            }
        }
        return ans;
    }
}
/*
在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。

给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。

注意：分割得到的每个字符串都必须是平衡字符串。

返回可以通过分割得到的平衡字符串的 最大数量 。
 */