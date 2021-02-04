package P31下一个排列;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {

        if(nums == null){
            return;
        }
        else if(nums.length == 1){
            return;
        }
        else if(nums.length == 2){
            int step = nums[0];
            nums[0] = nums[1];
            nums[1] = step;
            return;
        }

        for (int i=nums.length-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                solve(nums,i);
                Arrays.sort(nums,i+1,nums.length);
                return;
            }
        }

        Arrays.sort(nums);
    }
    void solve(int[] nums,int t){
        int min = Integer.MAX_VALUE;
        int step = 0;
        for(int i = t+1;i < nums.length ;i++){
            if(nums[i] > nums[t] && min > nums[i]){
                step = i;
                min = nums[i];
            }
        }
        int p = nums[t];
        nums[t] = nums[step];
        nums[step] = p;

    }

}
