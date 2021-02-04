package 剑指offer64;

import java.util.stream.IntStream;

class Solution {
    public int sumNums(int n) {
        return IntStream.range(1,n+1).sum();
    }
}