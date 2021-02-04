package P976三角形的最大周长;

import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 2 ; i--) {
            if(A[i] > A[i-1] + A[i-2]){
                return A[i] + A[i-1] + A[i-2] ;
            }
        }
        return 0 ;
    }

}