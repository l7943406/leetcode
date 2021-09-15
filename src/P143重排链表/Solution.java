package P143重排链表;

import java.util.Deque;
import java.util.LinkedList;

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

/** 空间复杂度On解法 */
class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        while (head != null){
            deque.addLast(head);
            head = head.next;
        }

        ListNode last = new ListNode();
        while (!deque.isEmpty()){
            ListNode l = deque.pollFirst();
            if(deque.isEmpty()){
                last.next = l;
                last = l;
                break;
            }
            ListNode r = deque.pollLast();
            last.next = l;
            l.next = r;
            last = r;
        }
        if(last != null){
            last.next = null;
        }
    }
}