package P142环形链表II;

import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
/**
 * hash 解法 空间复杂度O(n)
 * @author muchen
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Object> map = new HashMap<>();
        for (ListNode i = head; i != null ; i = i.next) {
            if(map.containsKey(i)){
                return i;
            }
            map.put( i, null);
        }
        return null;
    }
}