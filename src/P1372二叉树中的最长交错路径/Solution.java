package P1372二叉树中的最长交错路径;


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
    public int longestZigZag(TreeNode root) {
        dfs(root.left,1,true);
        dfs(root.right,1,false);
        return ans;
    }
    private void dfs(TreeNode root, int step, boolean left){
        if(root == null){
            ans = Math.max(ans, step - 1);
            return;
        }
        if(left){
            dfs(root.right, step + 1, false);
            dfs(root.left, 1, true);
        }else{
            dfs(root.left, step + 1, true);
            dfs(root.right, 1, false);
        }
    }
}
/*
给你一棵以root为根的二叉树，二叉树中的交错路径定义如下：

选择二叉树中 任意节点和一个方向（左或者右）。
如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
改变前进方向：左变右或者右变左。
重复第二步和第三步，直到你在树中无法继续移动。
交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。

请你返回给定树中最长 交错路径的长度。
*/