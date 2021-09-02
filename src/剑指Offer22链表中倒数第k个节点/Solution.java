package 剑指Offer22链表中倒数第k个节点;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode t = head;
        for (int i = 0; i < k; i++) {
            if(t == null){
                return null;
            }
            t = t.next;
        }
        ListNode ans = head;
        while (t != null){
            t = t.next;
            ans = ans.next;
        }
        return ans;

    }
}