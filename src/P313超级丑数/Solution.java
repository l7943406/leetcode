package P313超级丑数;

import java.util.PriorityQueue;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        long res = 1;
        for (int i = 1; i < n; i++) {
            for(int prime : primes){
                queue.add(prime * res);
            }
            res = queue.poll();
            while (!queue.isEmpty() && res == queue.peek()){
                queue.poll();
            }
        }
        return (int) res;
    }

}
/*

超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。

给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。

题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。

 */