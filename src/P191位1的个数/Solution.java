package P191位1的个数;

public class Solution {
    // you need to treat n as an unsigned value
    /*
    狗头
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
     */
    public int hammingWeight(int n) {
        boolean[] bit = new boolean[32];
        int now = 31;
        if (n < 0) {
            n = -n;
            while (n != 0) {
                bit[now --] = n % 2 != 0;
                n /= 2;
            }
            for (int i = 0; i < bit.length; i++) {
                bit[i] = !bit[i];
            }
            for (int i = 31; i >= 0; i--) {
                if(bit[i]){
                    bit[i] = false;
                }else{
                    bit[i] = true;
                    break;
                }
            }
        } else {
            while (n != 0) {
                bit[now --] = n % 2 != 0;
                n /= 2;
            }
        }
        int ans = 0;
        for (boolean b : bit) {
            if (b) {
                ans++;
            }
        }
        return ans;
    }
}