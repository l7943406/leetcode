package P865具有所有最深节点的最小子树;


import java.util.*;

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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        TreeNode flag = new TreeNode(-1);

        int top = 0;
        queue.add(root);
        queue.add(flag);

        while (top < queue.size()){
            TreeNode now = queue.get(top++);
            if(now.val == flag.val && top < queue.size()){
                queue.add(flag);
                continue;
            }
            if(now.left != null){
                map.put(queue.size(), top - 1);
                queue.add(now.left);
            }
            if(now.right != null) {
                map.put(queue.size(), top - 1);
                queue.add(now.right);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = queue.size() - 1; i >= 0; i--) {
            TreeNode now = queue.get(i);
            if(now.val == flag.val){
                if(!list.isEmpty()){
                    break;
                }
                continue;
            }
            list.add(i);
        }

        Integer[] nodes = list.toArray(new Integer[0]);

        while (true) {
            boolean f = true;
            for (int i = 1; i < nodes.length; i++) {
                if (!nodes[i].equals(nodes[i - 1])) {
                    f = false;
                    break;
                }
            }
            if (f) {
                return queue.get(nodes[0]);
            }

            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = map.get(nodes[i]);
            }
        }

    }

}
/*

给定一个根为root的二叉树，每个节点的深度是 该节点到根的最短距离 。

如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。

一个节点的 子树 是该节点加上它的所有后代的集合。

返回能满足 以该节点为根的子树中包含所有最深的节点 这一条件的具有最大深度的节点。

 */