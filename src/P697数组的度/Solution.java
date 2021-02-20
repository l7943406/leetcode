package P697数组的度;

import java.util.Arrays;

class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] book = new int[50000];
        int[] start = new int[50000];
        int[] end = new int[50000];
        int max = 0;
        int min = 50001;
        for (int i = 0; i < nums.length; i++) {
            if(book[nums[i]] == 0){
                start[nums[i]] = i;
            }else{
                end[nums[i]] = i;
            }
            book[nums[i]] ++;
        }
        for(int i : book){
            max = Math.max(i,max);
        }
        for (int i = 0; i < 50000; i++) {
            if(book[i] == max){
                min = Math.min(min,end[i] - start[i]);
            }
        }

        return min;
    }
}