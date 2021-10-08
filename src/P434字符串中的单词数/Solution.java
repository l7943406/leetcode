package P434字符串中的单词数;

class Solution {
    public int countSegments(String string) {
        byte[] s = string.getBytes();
        int ans = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i] != ' ' && (i - 1 < 0 || s[i - 1] == ' ')){
                ans++;
            }
        }
        return ans;
    }
}