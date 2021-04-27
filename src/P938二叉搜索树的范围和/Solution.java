package P938二叉搜索树的范围和;

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
    int ans = 0;
    int low;
    int high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        BST(root);
        return ans;
    }
    public void BST(TreeNode root){
        if(root == null){
            return;
        }
        if(root.val <= high && root.val >= low){
            ans += root.val;
            BST(root.left);
            BST(root.right);
        }else if(root.val > high){
            BST(root.left);
        }else{
            BST(root.right);
        }
    }
}