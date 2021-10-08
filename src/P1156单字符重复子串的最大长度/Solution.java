package P1156单字符重复子串的最大长度;

class Solution {
    public int maxRepOpt1(String text) {
        if(text == null || text.length() == 0){
            return 0;
        }
        byte[] s = text.getBytes();
        int[] map = new int[26];
        for(byte c : s){
            map[c - 'a'] ++;
        }
        int ans = 1;
        int count = 1;
        for (int i = 1; i < s.length; i++) {
            if(s[i] != s[i - 1]){
                if(i + 1 < s.length && s[i + 1] == s[i - 1]){
                    count ++;
                    for (int j = i + 2; j < s.length; j++) {
                        if(s[j] != s[j - 1]){
                            break;
                        }
                        count++;
                    }
                }
                if(count < map[s[i - 1] - 'a']){
                    count++;
                }
                ans = Math.max(ans, count);
                count = 1;
            }else{
                count++;
            }
        }
        if(count < map[s[s.length - 1] - 'a']){
            count++;
        }
        ans = Math.max(ans, count);
        return ans;
    }

}