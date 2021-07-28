package P1790仅执行一次字符串交换能否使两个字符串相等;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char lastL1 = ' ';
        char lastL2 = ' ';
        boolean have = false;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                if(have){
                    if(lastL1 == '1'){
                        return false;
                    }
                    if(s1.charAt(i) != lastL2 || s2.charAt(i) != lastL1){
                        return false;
                    }else{
                        lastL1 = '1';
                    }
                }else{
                    have = true;
                    lastL1 = s1.charAt(i);
                    lastL2 = s2.charAt(i);
                }
            }
        }
        return !have || lastL1 == '1';
    }
}
/*
"hewoliayeotlurq"
"hewalioyeotlurq"
给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。

如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 */