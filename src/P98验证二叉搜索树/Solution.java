package P98验证二叉搜索树;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
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
    long num = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean l = isValidBST(root.left);
        boolean n = root.val > num;
        num = root.val;
        boolean r = isValidBST(root.right);
        return l && n && r;
    }

}