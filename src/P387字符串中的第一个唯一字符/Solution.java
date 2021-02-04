package P387字符串中的第一个唯一字符;

import java.util.Arrays;

//class Solution {
//    public int firstUniqChar(String s) {
//        int[] book = new int[26];
//        Arrays.fill(book,-1);
//        for (int i = 0; i < s.length(); i++) {
//            int t = book[s.charAt(i) - 'a'];
//            if(t == -1){
//                book[s.charAt(i) - 'a'] = i;
//            }else{
//                book[s.charAt(i) - 'a'] = -2;
//            }
//        }
//        int min = -1;
//        for (int i = 0; i < 26; i++) {
//            if(book[i] != -2 && book[i] != -1){
//                if(min == -1 || book[i] < min){
//                    min = book[i];
//                }
//            }
//        }
//        return min ;
//
//    }
//
//    public static void main(String[] args) {
//        new Solution().firstUniqChar("leetcode");
//
//    }
//}

class Solution {
    public int firstUniqChar(String s) {
        if(s == null){
            return -1;
        }
        for (int i = 0; i < s.length() ; i++) {
            char t = s.charAt(i);
            if(s.indexOf(t) == s.lastIndexOf(t)){
                return i;
            }
        }
        return -1;
    }

}