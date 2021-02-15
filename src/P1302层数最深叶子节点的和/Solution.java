package P1302层数最深叶子节点的和;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int max = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        solve(root,0);
        int ans = 0;
        List<Integer> list = map.get(max);
        for(Integer i : list){
            ans += i;
        }
        return ans;
    }
    public void solve(TreeNode root,int floor){
        if(root == null){
            return;
        }
        max = Math.max(max,floor);
        if(root.left == null && root.right == null){
            if(!map.containsKey(floor)){
                map.put(floor,new ArrayList<>());
            }
            map.get(floor).add(root.val);
        }
        solve(root.left,floor+1);
        solve(root.right,floor+1);

    }
}