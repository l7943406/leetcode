package P303区域和检索数组不可变;

class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++) {
            this.nums[i] += this.nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return i > 0 ? nums[j] - nums[i - 1] : nums[j];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */