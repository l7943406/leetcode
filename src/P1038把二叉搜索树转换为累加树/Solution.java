package P1038把二叉搜索树转换为累加树;

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
    public TreeNode bstToGst(TreeNode root) {
        solve(root);
        return root;
    }
    int num = 0;
    public void solve(TreeNode root) {
        if(root == null){
            return;
        }
        solve(root.right);
        num += root.val;
        root.val = num;
        solve(root.left);
    }
}