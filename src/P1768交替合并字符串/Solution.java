package P1768交替合并字符串;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < word1.length() && i < word2.length(); i++) {
            ans.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if(word1.length() > word2.length()){
            ans.append(word1.substring(word2.length()));
        }else{
            ans.append(word2.substring(word1.length()));
        }
        return ans.toString();
    }
}