package P141环形链表;


import java.util.HashMap;
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
    public boolean hasCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        for(ListNode i=head;i != null;i = i.next){
            if(map.containsKey(i)){
                return true;
            }
            map.put(i,i.val);
        }
        return false;

    }
}