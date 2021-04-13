package P783二叉搜索树节点最小距离;

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
    int pre;
    int ans;
    public int minDiffInBST(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        ldr(root);
        return ans;
    }
    public void ldr(TreeNode root){
        if (root == null) {
            return;
        }
        ldr(root.left);
        if (pre != -1) {
            ans = Math.min(ans,root.val - pre);
        }
        pre = root.val;
        ldr(root.right);
    }
}