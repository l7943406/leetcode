package P1863找出所有子集的异或总和再求和;

class Solution {
    int[] nums;
    int ans;
    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        dfs(0,0);
        return ans;
    }
    public void dfs(int index,int num){
        if(index == nums.length){
            ans += num;
            return;
        }
        dfs(index + 1,num);
        dfs(index + 1,num ^ nums[index]);
    }

}
