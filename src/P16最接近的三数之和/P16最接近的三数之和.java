package P16最接近的三数之和;

import java.util.*;

class SolutionP16 {
    public int[] nums;
    public int target;
    public int ans;
    public int min;

    public int threeSumClosest(int[] nums, int target) {
        this.target=target;
        this.nums=nums;
        this.ans=nums[0]+nums[1]+nums[2];
        this.min=Math.abs(nums[0]+nums[1]+nums[2]-target);
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i++) {
            solve(i);
        }
        return ans;
    }
    public void solve(int t){
        int king;
        int left;
        for (int i = 0; i < t; i++) {
            left=nums[i];
            king=nums[t];
            find(left+king,t);
        }
    }
    public void find(int sum,int t){
        for(int i=t+1 ; i< nums.length ; i++){
            if(Math.abs(nums[i]+sum-target)<min){
                ans=nums[i]+sum;
                min=Math.abs(nums[i]+sum-target);
            }
        }
    }

    public static void main(String[] args) {
        int[] s={1,1,1,0};
        System.out.println(new SolutionP16().threeSumClosest(s,-100));
    }
}
