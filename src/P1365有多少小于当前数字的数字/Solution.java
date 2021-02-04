package P1365有多少小于当前数字的数字;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[101];
        int[] arr2 = new int[101];
        int[] ans = new int[nums.length];

        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            arr2[i] = arr2[i] +  arr2[i-1] + arr[i-1] ;
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = arr2[nums[i]];
        }
        return ans;
    }
}

