package P199二叉树的右视图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    Map<Integer,Integer> map;
    List<Integer> ans;
    int high;
    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        if(root == null){
            return ans;
        }
        f(root,0);
        for (int i = 0; i <= high; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
    public void f(TreeNode node , int floor){
        if(node == null){
            return ;
        }
        high = Math.max(floor,high);
        map.put(floor,node.val);
        f(node.left,floor + 1);
        f(node.right,floor + 1);
    }
}