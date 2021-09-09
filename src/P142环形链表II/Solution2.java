package P142环形链表II;

import java.util.HashMap;

public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                return null;
            }
            fast = fast.next;
            if(fast == slow){
                ListNode ans = head;
                while (ans != slow){
                    ans = ans.next;
                    slow = slow.next;
                }
                return ans;
            }
        }
        return null;
    }
}
/*
证明:快指针只要到null说明无环
    每走一轮 fast与slow距离+1 fast会遇到slow

*/