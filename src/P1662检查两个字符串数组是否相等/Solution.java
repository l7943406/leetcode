package P1662检查两个字符串数组是否相等;

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (String s:word1) {
            s1.append(s);
        }
        for (String s:word2) {
            s2.append(s);
        }
        String ss1 = new String(s1);
        String ss2 = new String(s2);
        return ss1.compareTo(ss2)!=0;
    }
}