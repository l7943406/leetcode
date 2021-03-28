package P173二叉搜索树迭代器;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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
/*
空间复杂度O（n）解法
class BSTIterator {
    ArrayList<Integer> list ;
    int index;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        init(root);
        index = 0;
    }

    public void init(TreeNode root){
        if(root == null){
            return;
        }
        init(root.left);
        list.add(root.val);
        init(root.right);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }
}
*/

class BSTIterator {
    TreeNode t;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        t = root;
    }


    public int next() {
        while (t!=null){
            stack.push(t);
            t = t.left;
        }
        TreeNode now = stack.pop();
        if(now.right!=null){
            t = now.right;
        }
        return now.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || t != null;
    }
}