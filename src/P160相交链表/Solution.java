package P160相交链表;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> map = new HashMap<>();
        for(ListNode i = headA ;  i != null ; i=i.next){
            map.put(i,i.val);
        }
        for(ListNode i = headB ;  i != null ; i=i.next){
            if(map.containsKey(i)){
                return i;
            }
        }
        return null;
    }
}