package P1004最大连续1的个数III;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int longestOnes(int[] A, int K) {
        int i = 0,j = 0,num = 0;
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (i = 0; i < A.length; i++) {
            if(A[i] == 0){
                queue.add(i);
                num ++;
                if(num > K){
                    j = queue.poll() + 1;
                }
            }
            ans = Math.max(ans,i - j + 1);
        }

        return ans;
    }
}