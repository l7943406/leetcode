package P1869哪种连续子字符串更长;

class Solution {
    public boolean checkZeroOnes(String s) {
        int one = 0;
        int zero = 0;
        int t = 0;
        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(lastIndex)){
                t++;
            }else{
                if(s.charAt(lastIndex) == '1'){
                    one = Math.max(one,t);
                }else{
                    zero = Math.max(zero,t);
                }
                lastIndex = i;
                t = 1;
            }
        }
        if(s.charAt(lastIndex) == '1'){
            one = Math.max(one,t);
        }else{
            zero = Math.max(zero,t);
        }
        return one > zero;

    }


}