package P1704判断字符串的两半是否相似;

class Solution {
    public boolean halvesAreAlike(String s) {
        char[] o = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        byte[] b = s.getBytes();
        int[] map = new int[200];
        for (int i = 0; i < b.length / 2; i++) {
            map[b[i]]++;
        }
        for (int i = b.length / 2; i < b.length; i++) {
            map[b[i]]--;
        }
        int sum = 0;
        for (char c : o) {
            sum += map[c];
        }
        return sum == 0;
    }
}
/*
给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。

两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。

如果 a 和 b 相似，返回 true ；否则，返回 false 。
 */