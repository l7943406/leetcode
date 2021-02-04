package P258各位相加;

class Solution {
    public int addDigits(int num) {
        while(num/10!=0){
            num = f(num);
        }
        return num;
    }
    int f(int n){
        if(n == 0){
            return 0;
        }
        return f(n/10) + n % 10;
    }
}