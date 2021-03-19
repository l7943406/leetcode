package P92反转链表Ⅱ;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){
            return head;
        }
        ListNode start = head,t;
        t = head;
        int[] arr = new int[n - m + 1];
        for (int i = 0; i < n; i++) {
             if(i >= m - 1){
                 if(i == m - 1){
                     start = t;
                 }
                arr[i - m + 1] = t.val;
            }
             t = t.next;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (int i = 0; i <= n - m; i++) {
            start.val = arr[n - m - i];
            start = start.next;
        }
        return head;
    }
}