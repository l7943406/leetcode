package P109有序链表转换二叉搜索树;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
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
    ArrayList<Integer> list;
    public TreeNode sortedListToBST(ListNode head) {
        this.list = new ArrayList<>();
        for (ListNode i = head; i != null ; i = i.next) {
            list.add(i.val);
        }
        return creat(0, list.size() - 1);
    }
    private TreeNode creat(int l, int r){
        if(l > r){
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = creat( l, mid - 1);
        node.right = creat( mid + 1 , r);
        return node;
    }
}