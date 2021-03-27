package P61旋转链表;

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
        this.val = val; this.next = next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null){
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        for(ListNode i = head; i != null; i = i.next){
            list.add(i);
        }
        k %= list.size();
        list.get(list.size() - 1).next = list.get(0);
        list.get(list.size() - 1 - k).next = null;
        return list.get((list.size() - k) % list.size());
    }
}