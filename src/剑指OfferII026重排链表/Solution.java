package 剑指OfferII026重排链表;

import java.util.ArrayList;
import java.util.LinkedList;
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
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode i = head; i != null; i = i.next) {
            nodes.add(i);
        }
        ListNode last = new ListNode();
        if(nodes.size() % 2 == 0){
            for (int i = 0; i < nodes.size() / 2; i++) {
                last.next = nodes.get(i);
                nodes.get(i).next = nodes.get(nodes.size() - i - 1);
                last = nodes.get(nodes.size() - i - 1);
                last.next = null;
            }
        }else{
            for (int i = 0; i < nodes.size() / 2; i++) {
                last.next = nodes.get(i);
                nodes.get(i).next = nodes.get(nodes.size() - i - 1);
                last = nodes.get(nodes.size() - i - 1);
                last.next = null;
            }
            last.next = nodes.get(nodes.size() / 2);
            last.next.next = null;
        }

    }
}