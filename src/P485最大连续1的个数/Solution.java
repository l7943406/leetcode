package P485最大连续1的个数;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int num = 0;
        int ans = 0;
        for (int i : nums) {
            if(i == 1){
                num ++;
            }else{
                ans = Math.max(ans,num);
                num = 0;
            }
        }
        ans = Math.max(ans,num);
        return ans;
    }
}