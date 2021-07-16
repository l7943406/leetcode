package P866回文素数;

class Solution {
    public int primePalindrome(int n) {
        //取n的位数
        int num = n;
        int bit = 0;
        while (num != 0){
            num /= 10;
            bit++;
        }

        //特判一下 1 - 11
        for (int i = 0; i <= 11; i++) {
            if(isPrime(i) && i >= n){
                return i;
            }
        }
        //把bit变成奇数位
        if(bit % 2 == 0){
            bit++;
        }
        int[] can = new int[]{1,3,7,9};
        for (int i = bit; i < 10; i += 2) {
            int l = (int) Math.pow(10, i / 2);
            for (int j : can) {
                if(Math.pow(10, i + 1) * j <= n){
                    continue;
                }
                for (int k = j * l; k < (j + 1) *  l; k++) {
                    int newNum = getPalindrome(k);
                    if (newNum >= n && isPrime(newNum)) {
                        return newNum;
                    }
                }
            }
        }

        return 0;
    }

    public boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num) ; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public int getPalindrome(int num){
        //将数字去掉第一位并反转加在num上
        int t = num;
        num /= 10;
        while (t != 0){
            num *= 10;
            num += t%10;
            t/=10;
        }
        return num;
    }



}