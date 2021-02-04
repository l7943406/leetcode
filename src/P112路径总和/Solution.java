package P112路径总和;



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    int sum ;
    boolean isTrue = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        traverse(root,root.val);
        return isTrue;
    }
    public void traverse(TreeNode node , int num){
        if(num == sum){
            isTrue = true;
        }
        if(isTrue){
            return;
        }
        if(node.left!=null){
            traverse(node.left,num + node.left.val);
        }
        if(node.right!=null){
            traverse(node.right,num + node.right.val);
        }
    }

}