package P147对链表进行插入排序;

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
    public ListNode insertionSortList(ListNode head) {
        ListNode ans = new ListNode(0,head);

        ListNode last = ans;
        ListNode now = ans.next;

        while (now != null){




            last = now;
            now = now.next;
        }


        return ans.next;
    }

}