package 剑指OfferII045二叉树最底层最左边的值;

import java.util.Deque;
import java.util.LinkedList;

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
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        TreeNode ans = root;
        while (!deque.isEmpty()){
            ans = deque.peekFirst();
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = deque.pollFirst();
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
        }
        return ans.val;
    }
}