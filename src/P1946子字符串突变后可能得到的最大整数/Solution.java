package P1946子字符串突变后可能得到的最大整数;

class Solution {
    public String maximumNumber(String num, int[] change) {
        byte[] s = num.getBytes();
        for (int i = 0; i < s.length; i++) {
            if(change[s[i] - '0'] > s[i] - '0'){
                for (int j = i; j < s.length; j++) {
                    if(change[s[j] - '0'] >= s[j] - '0'){
                        s[j] = (byte) (change[s[j] - '0'] + '0');
                    }else{
                        return new String(s);
                    }
                }
                return new String(s);
            }
        }
        return new String(s);
    }
}
/*

"214010"
[6,7,9,7,4,0,3,4,4,7]

"974010"
"974676"
* */