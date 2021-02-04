package P654最大二叉树;


import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return constructMaximumBinaryTree(0,nums.length);
    }
    public TreeNode constructMaximumBinaryTree(int left , int right) {
        if(left == right){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = left; i < right; i++) {
            if(nums[i] > max){
                max = i;
                maxIndex = i;
            }
        }
        return new TreeNode(max,constructMaximumBinaryTree(left,maxIndex-1),constructMaximumBinaryTree(maxIndex + 1,right));
    }
}