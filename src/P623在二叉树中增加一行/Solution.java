package P623在二叉树中增加一行;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int v,d;
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            node.right = null;
            return node;
        }
        this.d = d - 1;
        this.v = v;
        solve(root,1);
        return root;
    }
    void solve(TreeNode node, int floor){
        if(node == null){
            return;
        }
        if(floor == d){
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);

            left.left = node.left;
            node.left = left;

            right.right = node.right;
            node.right = right;
            return;
        }
        solve(node.left,floor+1);
        solve(node.right,floor+1);
    }

}