package P896单调数列;

class Solution {
    public boolean isMonotonic(int[] A) {
        boolean big = false;
        int n = 0;
        for (int i = 1; i < A.length; i++) {
            if(A[i- 1] < A[i]){
                big = false;
                n = i;
                break;
            }else if(A[i - 1] > A[i]){
                big = true;
                n = i;
                break;
            }
        }
        if(n == 0){
            return true;
        }
        if(big){
            for (int i = n + 1; i < A.length; i++) {
                if(A[i-1] < A[i]){
                    return false;
                }
            }
        }else{
            for (int i = n + 1; i < A.length; i++) {
                if(A[i-1] > A[i]){
                    return false;
                }
            }
        }
        return true;
    }

}