package P1281整数的各位积和之差;

class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int and = 0;
        while(n != 0){
            product *= n%10;
            and += n%10;
            n/=10;
        }
        return product - and;
    }
} 