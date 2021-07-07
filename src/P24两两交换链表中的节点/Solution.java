package P24两两交换链表中的节点;

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
    public ListNode swapPairs(ListNode head) {
        ListNode t = head;
        ListNode[] nodes = new ListNode[2];
        ListNode ans = new ListNode();
        int index = 0;
        nodes[index ++] = ans;
        ans.next = head;
        while (t != null){
            if(index == 2){
                nodes[0].next = t;
                nodes[1].next = t.next;
                t.next = nodes[1];
                t = nodes[1].next;

                nodes[0] = nodes[1];
                index = 1;
            }else{
                nodes[index ++] = t;
                t = t.next;
            }
        }
        return ans.next;
    }
}
