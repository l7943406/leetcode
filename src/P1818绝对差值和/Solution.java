package P1818绝对差值和;

import java.util.Arrays;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long ans = 0;
        int[] nums3 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nums3[i] = Math.abs(nums1[i] - nums2[i]);
            ans += nums3[i];
        }
        Arrays.sort(nums1);
        int distance = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            int oldNum = nums3[i];
            int newNum = searchMinDifference(nums1,nums2[i]);
            distance = Math.max(distance,oldNum - newNum);
        }
        ans -= distance;

        return (int)(ans % (1e9+7));
    }
    public int searchMinDifference(int[] nums,int num){
        int index = Arrays.binarySearch(nums,num);
        if(index >= 0){
            return 0;
        }
        index = - index - 1;
        int ans = Integer.MAX_VALUE;
        if(index < nums.length){
            ans = Math.min(ans,Math.abs(nums[index] - num));
        }
        if(index - 1 >= 0){
            ans = Math.min(ans,Math.abs(nums[index - 1] - num));
        }
        return ans;
    }
}
