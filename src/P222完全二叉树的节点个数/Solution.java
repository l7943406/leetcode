package P222完全二叉树的节点个数;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//class Solution {
//    public int countNodes(TreeNode root) {
//        if(root!=null){
//            return countNodes(root.left) + countNodes(root.right) + 1;
//        }else{
//            return 0;
//        }
//    }
//}

//
//class Solution {
//    public int countNodes(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int ans = 0;
//        while(!queue.isEmpty()){
//            TreeNode t = queue.poll();
//            if(t!=null){
//                ans++;
//                queue.offer(t.left);
//                queue.offer(t.right);
//            }
//
//        }
//        return ans;
//    }
//}