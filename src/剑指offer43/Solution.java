package 剑指offer43;

class Solution {
    public int countDigitOne(int n) {
        int ans = 0;
        int last = 0;
         while(n!=0){
             last = n%10;
             n/=10;
             ans = ans + n + f(last);
         }
         return ans;
    }
    int f(int n){
        if(n >= 1){
            return 1;
        }
        return 0;
    }
}