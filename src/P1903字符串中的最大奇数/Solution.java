package P1903字符串中的最大奇数;

class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if((num.charAt(i) - '0')  % 2 == 1){
                return num.substring(0,i + 1);
            }
        }
        return "";
    }
}
/*
给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。

子字符串 是字符串中的一个连续的字符序列。
 */