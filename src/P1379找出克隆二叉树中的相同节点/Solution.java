package P1379找出克隆二叉树中的相同节点;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}




class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return null;
        }
        if(original == target){
            return cloned;
        }
        TreeNode t1 = getTargetCopy(original.left,cloned.left,target);
        TreeNode t2 = getTargetCopy(original.right,cloned.right,target);
        if(t1!=null){
            return t1;
        }
        return t2;
    }
}