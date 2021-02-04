package P107二叉树层序遍历;

import java.util.*;

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
        TreeNode treeNode;
        public Tree(int floor,TreeNode t){
            this.floor=floor;
            this.treeNode=t;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Tree> queue = new ArrayList<>();
        int i=0;
        int j=1;

        queue.add(new Tree(0,root));
        while(i<j){
            Tree tree = queue.get(i);
            if(tree.treeNode.left!=null){
                queue.add(new Tree(tree.floor+1,tree.treeNode.left));
                j++;
            }
            if(tree.treeNode.right!=null){
                queue.add(new Tree(tree.floor+1,tree.treeNode.right));
                j++;
            }
            i++;
        }

        for(i=0;i<queue.size();i++){
            List<Integer> list = new ArrayList<>();
            int floor=queue.get(i).floor;
            for(;i<queue.size();i++){
                if(queue.get(i).floor == floor){
                    list.add(queue.get(i).treeNode.val);
                }else{
                    i--;
                    break;
                }
            }
            ans.add(list);
        }
        Collections.reverse(ans);
        return ans;
    }
}