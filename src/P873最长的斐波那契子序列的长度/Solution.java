package P873最长的斐波那契子序列的长度;

import java.util.Arrays;
import java.util.HashMap;


/*
* 朴素O(n^2*log2n)
* */
class Solution {

    int[] arr;
    HashMap<Integer,Integer> map = new HashMap<>();
    int ans = 0;
    public int lenLongestFibSubseq(int[] arr) {

        this.arr = arr;

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                solve(i,j,2);
            }
        }

        return ans > 2 ? ans : 0;
    }
    public void solve(int index1,int index2,int step){
        ans = Math.max(step,ans);
        Integer next = map.get(arr[index1] + arr[index2]);
        if(next != null){
            solve(index2,next,step + 1);
        }
    }
}
