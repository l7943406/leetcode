package P25K个一组翻转链表;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
//todo k空间复杂度o1算法未完成！！！
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode t = head;
        for (int i = 0; i < k; i++) {
            if(t == null){
                return head;
            }
            t = t.next;
        }
        if(k < 3){

        }
        ListNode nextReverse = t;
        t = head;
        return head;

    }
}