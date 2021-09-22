package P725分隔链表;

class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next; }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(head == null){
            return new ListNode[k];
        }
        ListNode[] ans = new ListNode[k];
        int n = 0;

        ListNode l;
        ListNode r;
        l = head;
        while (l != null){
            l = l.next;
            n++;
        }
        l = head;

        int flag = 0;
        int index = 0;
        int baseLength = n / k;
        int andLength = n % k;

        while (l != null) {
            ans[index++] = l;
            if(andLength > 0){
                andLength --;
                flag = 1;
            }else{
                flag = 0;
            }
            for (int i = 0; i < baseLength + flag - 1; i++) {
                l = l.next;
            }

            r = l.next;
            l.next = null;
            l = r;
        }

        return ans;
    }
}