package 剑指OfferII024反转链表;

class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode t = head.next;
        ListNode p = head.next.next;
        head.next = null;
        t.next = head;
        while (p != null){
            ListNode l = t;
            t = p;
            p = p.next;
            t.next = l;
        }
        return t;
    }
}