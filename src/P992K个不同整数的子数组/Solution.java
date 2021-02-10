package P992K个不同整数的子数组;

import java.util.Arrays;

class Solution {
    private int[] nums;
    private int size;
    public int subarraysWithKDistinct(int[] A , int K){
        return solve(A,K) - solve(A,K-1);
    }
    private int solve(int[] A, int K) {
        this.nums = new int[A.length + 1];
        this.size = 0;
        int ans = 0;
        int l = 0;
        int r = 0;
        for(r = 0;r < A.length;r++) {
            increment(A[r]);
            while (num() > K) {
                decrement(A[l++]);
            }
            ans += r - l;

        }
        return ans;
    }
    private void decrement(int i){
        if(nums[i] == 1){
            size --;
        }
        nums[i] --;
    }
    private  void increment(int i){
        if(nums[i] == 0){
            size ++;
        }
        nums[i] ++;
    }
    private int num(){
        return size;
    }
    private void clear(){
        Arrays.fill(nums, 0);
        size = 0;
    }
}