package P206反转链表;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode l,r;
        l=head;
        r=head.next;
        l.next = null;
        while(r!=null){
            head = r.next;
            r.next = l;
            l = r;
            r = head;
        }
        return l;
    }
}