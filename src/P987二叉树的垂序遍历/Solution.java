package P987二叉树的垂序遍历;


import sun.reflect.generics.tree.Tree;

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

/**
 * 广搜 本来是想通过广搜不用再对深度排序,最后发现同深度同行下序号需要正序,淦
 * */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<Pair>> map = new HashMap<>(1024);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0,0));
        while (!queue.isEmpty()){
            Pair now = queue.poll();
            if(now.tree == null){
                continue;
            }
            map.putIfAbsent(now.index,new LinkedList<>());
            map.get(now.index).add(now);
            queue.add(new Pair(now.tree.left,now.index - 1,now.floor + 1));
            queue.add(new Pair(now.tree.right,now.index + 1,now.floor + 1));
        }
        List<List<Integer>> ans = new LinkedList<>();
        for(Map.Entry<Integer,List<Pair>> entry : map.entrySet()){
            List<Pair> list = entry.getValue();
            list.sort((a,b) -> {
                if(a.floor == b.floor){
                    return a.tree.val - b.tree.val;
                }
                return a.floor - b.floor;
            });
            List<Integer> l = new LinkedList<>();
            for (Pair p : list){
                l.add(p.tree.val);
            }
            ans.add(l);

        }
        return ans;

    }
    static class Pair{
        TreeNode tree;
        int index;
        int floor;
        public Pair(TreeNode tree, int index,int floor) {
            this.tree = tree;
            this.index = index;
            this.floor = floor;
        }
    }
}