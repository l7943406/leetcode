package P987二叉树的垂序遍历;


import java.util.*;

@SuppressWarnings("all")
class Solution2 {
    List<int[]> map = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        map.sort((a,b)->{ return a[1] == b[1] ? a[2] == b[2] ? a[0] - b[0] : a[2] - b[2] : a[1] - b[1]; });
        LinkedList<List<Integer>> ans = new LinkedList<>();
        int last = Integer.MAX_VALUE;
        for(int[] i : map){
            if(i[1] != last){
                ans.add(new LinkedList<>());
                last = i[1];
            }
            ans.peekLast().add(i[0]);
        }
        return ans;
    }

    private void dfs(TreeNode root,int index,int floor){
        if(root == null){
            return;
        }
        map.add(new int[]{root.val,index,floor});
        dfs(root.left,index - 1,floor + 1);
        dfs(root.right,index + 1,floor + 1);
    }
}