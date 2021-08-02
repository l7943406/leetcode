package P1669合并两个链表;

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = new ListNode(0,list1);


        ListNode last = head;
        for (int i = 0; i < a; i++) {
            last = last.next;
        }
        ListNode t = last.next;
        last.next = list2;
        last = t;

        for (int i = 0; i < b - a; i++) {
            last = last.next;
        }

        while (list2.next != null){
            list2 = list2.next;
        }

        list2.next = last.next;



        return head.next ;
    }
}