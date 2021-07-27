package P671二叉树中第二小的节点;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {

    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    long min;
    long secondMin;
    public int findSecondMinimumValue(TreeNode root) {
        this.min = Long.MAX_VALUE;
        this.secondMin = Long.MAX_VALUE;
        ergodic(root);
        return secondMin == Long.MAX_VALUE ? -1 : (int)secondMin;
    }
    public void ergodic(TreeNode root){
        if(root == null){
            return;
        }
        min(root.val);
        ergodic(root.left);
        ergodic(root.right);
    }

    public void min(int val){
        if(val < min){
            secondMin = min;
            min = val;
        } else if(val != min && val < secondMin){
            secondMin = val;
        }
    }

}