package P908最小差值;

import java.util.Arrays;

class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            max = Math.max(max,A[i]);
            min = Math.min(min,A[i]);
        }
        if(2*K >=max-min) {
            return 0;
        }else{
            return max - min - 2*K;
        }

    }
}