package P995K连续位的最小翻转次数;

import java.util.Arrays;

class Solution {
    public int minKBitFlips(int[] A, int K) {
        int ans = 0;
        int[] book = new int[A.length];
        int fan = 0;
        for (int i = 0; i < A.length; i++) {
            fan += book[i];
            if((A[i] + fan) % 2 == 0){
                if(i + K > A.length){
                    return -1;
                }
                fan ++;
                book[i + K - 1] --;
                ans ++;
            }
        }
        return ans;
    }
}