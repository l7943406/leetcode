package P633平方数之和;

class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i = 0; i * i <= c; i++){
            double sqrt = Math.sqrt(c - i * i);
            if((int) sqrt == sqrt){
                return true;
            }
        }
        return false;

    }
}