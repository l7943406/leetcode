package 面试题02_07链表相交;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != null || l2 != null){
            if(l1 == null){
                l1 = headB;
            }
            if(l2 == null){
                l2 = headA;
            }
            if(l1 == l2){
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }
}