package P111二叉树的最小深度;



import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    class Tree {
        int floor;
        TreeNode tree;
        public Tree(int floor,TreeNode tree){
            this.floor = floor;
            this.tree = tree;
        }
    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<Tree> queue = new LinkedList<>();

        queue.offer(new Tree(1,root));

        while (!queue.isEmpty()){
            Tree tree = queue.poll();
            if(tree.tree.left==null&&tree.tree.right==null){
                return tree.floor;
            }
            if(tree.tree.left!=null){
                queue.offer(new Tree(tree.floor+1,tree.tree.left));
            }
            if(tree.tree.right!=null){
                queue.offer(new Tree(tree.floor+1,tree.tree.right));
            }
        }
        return 0;
    }
}