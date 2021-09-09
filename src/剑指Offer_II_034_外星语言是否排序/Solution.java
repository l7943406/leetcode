package 剑指Offer_II_034_外星语言是否排序;

class Solution {
    int[] map;
    public boolean isAlienSorted(String[] words, String order) {
        this.map = new int[26];
        int index = 0;
        for(byte c : order.getBytes()){
            this.map[c - 'a'] = index ++;
        }
        for (int i = 1; i < words.length; i++) {
            if(!solve(words[i-1].getBytes(), words[i].getBytes())){
                return false;
            }
        }
        return true;
    }
    private boolean solve(byte[] s1, byte[] s2){
        int n = Math.min(s1.length, s2.length);
        for (int i = 0; i < n; i++) {
            if(map[s1[i] - 'a'] > map[s2[i] - 'a']){
                return false;
            }else if(map[s1[i] - 'a'] < map[s2[i] - 'a']){
                return true;
            }
        }
        return s2.length >= s1.length;
    }
}
/*
某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。

给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 */