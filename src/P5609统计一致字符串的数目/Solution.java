package P5609统计一致字符串的数目;

class Solution {
    boolean[] book;
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        book = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            book[allowed.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < words.length; i++) {
            if(is(words[i])){
                ans++;
            }
        }
        return ans;
    }
    public boolean is(String word){
        boolean[] words = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            words[word.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < 26; i++) {
            if(words[i]&&!book[i]){
                return false;
            }
        }
        return true;
    }
}