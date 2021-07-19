package P86分隔链表;

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
        this.val = val; this.next = next;
    }
}

/*

ans - 2  - 1
* */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode least = null;
        ListNode ans = new ListNode(0,head);
        ListNode last = ans;
        for(ListNode i = head; i != null; i = i.next){
            if(i.val < x){
                if(least != null){
                    last.next = i.next;
                    i.next = least.next;
                    least.next = i;

                    least = i;
                    i = last;
                }
            }else if(least == null){
                least = last;
            }
            last = i;
        }
        return ans.next;
    }
}