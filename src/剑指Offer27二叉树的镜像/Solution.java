package 剑指Offer27二叉树的镜像;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        solve(root);
        return root;
    }
    public void solve(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        solve(root.left);
        solve(root.right);
    }
}