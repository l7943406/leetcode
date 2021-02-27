package P1290二进制链表转整数;

import java.util.ArrayList;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        for(ListNode i = head; i != null; i = i.next) {
            ans <<= 1;
            ans += i.val;
        }
        return ans;
    }
}