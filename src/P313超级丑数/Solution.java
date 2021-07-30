package P313超级丑数;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        for (int i = 0; i < primes.length; i++) {
            for (int j = i + 1; j < primes.length; j++) {
                System.out.print(" " + primes[j] * primes[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new Solution().nthSuperUglyNumber(0,new int[]{2,3,5});
    }
}
/*

超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。

给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。

题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。

 */