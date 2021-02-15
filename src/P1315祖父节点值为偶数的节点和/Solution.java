package P1315祖父节点值为偶数的节点和;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
        solve(root,1,1);
        return ans;
    }
    public void solve(TreeNode root,int father,int grandfather){
        if(root == null){
            return;
        }
        if(grandfather%2==0){
            ans += root.val;
        }
        solve(root.left,root.val,father);
        solve(root.right,root.val,father);
    }
}