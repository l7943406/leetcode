package P114二叉树展开为链表;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TransferQueue;

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
    ArrayList<TreeNode> list ;
    public void flatten(TreeNode root) {
        list = new ArrayList<>();
        f(root);
        Iterator<TreeNode> it = list.iterator();
        TreeNode last = null;
        if(it.hasNext()){
            last = it.next();
        }
        while (it.hasNext()){
            last.left = null;
            last.right = it.next();
            last = last.right;
        }
    }
    public void f(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root);
        f(root.left);
        f(root.right);
    }
}