package 面试题0403特定深度节点链表;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    Map<Integer,ListNode> ansMap;
    Map<Integer,ListNode> lastMap;
    int floor;
    public ListNode[] listOfDepth(TreeNode tree) {
        this.ansMap = new HashMap<>();
        this.lastMap = new HashMap<>();
        this.floor = 0;
        listOfDepth(tree , 0);
        ListNode[] result = new ListNode[floor + 1];
        for (int i = 0; i < floor + 1; i++) {
            result[i] = ansMap.get(i);
        }
        return result;

    }
    public void listOfDepth(TreeNode tree , int floor) {
        if(tree == null){
            return;
        }
        this.floor = Math.max(this.floor,floor);
        ListNode listNode = new ListNode(tree.val);
        listNode.next = null;
        if(ansMap.containsKey(floor)){
            lastMap.get(floor).next = listNode;
        }else{
            ansMap.put(floor,listNode);
        }
        lastMap.put(floor,listNode);
        listOfDepth(tree.left,floor + 1);
        listOfDepth(tree.right, floor + 1);
    }

}