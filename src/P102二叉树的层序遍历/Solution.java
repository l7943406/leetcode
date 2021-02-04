package P102二叉树的层序遍历;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //返回值
        List<List<Integer>> ans = new ArrayList<>();
        //特判
        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int t = 0;
        while(!queue.isEmpty()){

            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();

            t++;

            for (int i = 1; i <= currentLevelSize; ++i) {

                TreeNode node = queue.poll();

                assert node != null;

                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            if(t%2==0){
                Collections.reverse(level);
            }
            ans.add(level);

        }




        return ans;

    }
}