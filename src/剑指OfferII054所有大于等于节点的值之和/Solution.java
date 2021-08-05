package 剑指OfferII054所有大于等于节点的值之和;

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
    int num;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        convertBST(root.right);
        root.val +=  num;
        num = root.val;
        convertBST(root.left);
        return root;
    }
}
/*

给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。

提醒一下，二叉搜索树满足下列约束条件：

节点的左子树仅包含键 小于 节点键的节点。
节点的右子树仅包含键 大于 节点键的节点。
左右子树也必须是二叉搜索树。


 */