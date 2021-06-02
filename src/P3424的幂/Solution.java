package P3424的幂;

class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0){
            return false;
        }else{
            while(n != 1){
                if(n % 4 != 0){
                    return false;
                }
                n/=4;
            }
            return true;
        }
    }
}