package 剑指Offer58II左旋转字符串;

class Solution {
    public String reverseLeftWords(String s, int n) {
        n %= s.length();
        return new String(s.substring(n)+s.substring(0,n));
    }
}