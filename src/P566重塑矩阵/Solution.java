package P566重塑矩阵;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c!=nums.length*nums[0].length){
            return nums;
        }
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int num = c * i + j;
                ans[i][j] = nums[(int) Math.floor((double) num / nums[0].length)][num % nums[0].length];
            }
        }
        return ans;
    }
}