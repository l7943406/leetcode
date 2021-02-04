package P316去除重复字母;

class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] book = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            book[s.charAt(i) - 'a'] = true;
        }
        return null;
    }
}