package P395至少K个重复字符的最长子串;

class Solution {
    public int longestSubstring(String s, int k) {
        //遍历s，得出s中出现过的字母出现次数
        int[] allNum = new int[26];
        //记录s中出现的字母的出现次数是否比k大，作用：如果都比k大那s整个就是最长子串，返回数值给上一层循环，否则在下面循环中用小于k次的字符对字符串切片然后递归调用
        boolean[] moreK = new boolean[26];
        //遍历 s
        for (int i = 0; i < s.length(); i++) {
            allNum[s.charAt(i) - 'a'] ++;
        }
        //标记是否出现过的字母都大于等于k次
        boolean solve = true;
        for (int i = 0; i < 26; i++) {
            if(allNum[i] >= k || allNum[i] == 0){
                moreK[i] = true;
            }else{
                solve = false;
                moreK[i] = false;
            }
        }
        int ans = 0;
        //如果是直接返回s长度
        if(solve){
            return s.length();
        }
        //不是就递归处理用少于k次的字符切片的子字符串，并返回符合条件的最大值
        else {
            //记录上一个少于k次的字符位置
            int last = -1;
            for (int i = 0; i < s.length(); i++) {
                //如果没有出现过就更新last
                if (!moreK[s.charAt(i) - 'a']) {
                    //如果last在i-1后面就切片并递归调用
                    if (last != i - 1) {
                        ans = Math.max(ans, longestSubstring(s.substring(last + 1, i), k));
                    }
                    //更新last
                    last = i ;
                }
            }
            //用最后一个last的位置判断最后一个子串是否处理
            if(last < s.length() - 1){
                ans = Math.max(ans, longestSubstring(s.substring(last + 1), k));
            }
        }
        return ans;
    }
}