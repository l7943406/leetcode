package P1461检查一个字符串是否包含所有长度为K的二进制子串;


class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < (1 << k) + k - 1){
            return false;
        }
        boolean[] map = new boolean[1 << k];
        byte[] bytes = s.getBytes();
        int num = 0;
        int m = 1 << (k - 1);

        for (int i = 0; i < k; i++) {
            num <<= 1;
            if (bytes[i] == '1') {
                num ++;
            }
        }

        map[num] = true;
        for (int i = k; i < bytes.length; i++) {
            if(bytes[i - k] == '1'){
                num -= m;
            }
            num <<= 1;
            if(bytes[i] == '1'){
                num ++;
            }
            map[num] = true;
        }

        for(boolean b : map){
            if(!b){
                return false;
            }
        }
        return true;

    }

}