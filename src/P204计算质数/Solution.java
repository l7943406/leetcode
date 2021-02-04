package P204计算质数;

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 0; i < n; i++) {
            if(isPrime[i]){
                for (int j = i + i; j < n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(isPrime[i]){
                ans++;
            }
        }
        return ans;

    }
}