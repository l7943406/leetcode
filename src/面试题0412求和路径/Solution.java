package 面试题0412求和路径;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int ans = 0;
    int sum;
    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        ff(root);
        return ans;
    }
    public void ff(TreeNode node){
        if(node ==null){
            return;
        }
        f(node,0);
        ff(node.left);
        ff(node.right);
    }
    public void f(TreeNode node, int sum){
        if(node == null){
            return;
        }
        sum += node.val;
        if(sum == this.sum){
            ans++;
        }
        f(node.left,sum);
        f(node.right,sum);
    }
}