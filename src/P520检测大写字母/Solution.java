package P520检测大写字母;

class Solution {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() < 2){
            return true;
        }
        byte[] s = word.getBytes();
        if((s[0] >='A' && s[0] <='Z' || s[0] >='a' && s[0] <='z' )&& s[1] >='a' && s[1] <='z'){
            for (int i = 2; i < s.length; i++) {
                if(s[i] >='A' && s[i] <='Z')        {
                    return false;
                }
            }
        }else{
            for (byte b : s) {
                if (b >= 'a' && b <= 'z') {
                    return false;
                }
            }
        }
        return true;
    }
}
