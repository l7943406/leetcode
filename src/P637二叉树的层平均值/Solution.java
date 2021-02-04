package P637二叉树的层平均值;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    class Tree {
        double floor;
        TreeNode treeNode;
        public Tree(double floor, TreeNode t){
            this.floor=floor;
            this.treeNode=t;
        }
    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        ArrayList<Solution.Tree> queue = new ArrayList<>();
        int i=0;
        int j=1;

        queue.add(new Solution.Tree(0,root));
        while(i<j){
            Solution.Tree tree = queue.get(i);
            if(tree.treeNode.left!=null){
                queue.add(new Solution.Tree(tree.floor+1,tree.treeNode.left));
                j++;
            }
            if(tree.treeNode.right!=null){
                queue.add(new Solution.Tree(tree.floor+1,tree.treeNode.right));
                j++;
            }
            i++;
        }

        double d = 0;
        double t = 0;
        for(i=0;i<queue.size();i++){
            double floor=queue.get(i).floor;
            d = 0;
            t = 0;
            for(;i<queue.size();i++){

                if(queue.get(i).floor == floor){
                    d+=queue.get(i).treeNode.val;
                    t++;
                }else{
                    i--;
                    break;
                }
            }
            ans.add(d / t);
        }
        return ans;

    }

}