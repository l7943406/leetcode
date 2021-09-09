package P1513仅含1的子串数;

class Solution {
    public int numSub(String s) {
        long mod = 1000000007L;
        long ans = 0L;

        int count = 0;
        for(byte c : s.getBytes()){
            if(c == '0'){
                if(count != 0) {
                    ans += get(count) % mod;
                    ans %= mod;
                    count = 0;
                }
            }else{
                count ++;
            }
        }
        if(count != 0){
            ans += get(count) % mod;
            ans %= mod;
        }
        return (int)(ans % mod);
    }
    private long get(long count) {
        return (count * count + count) / 2;
    }

}
/*
给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。

返回所有字符都为 1 的子字符串的数目。

由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 */