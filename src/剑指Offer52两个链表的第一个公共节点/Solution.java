package 剑指Offer52两个链表的第一个公共节点;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
  |----
      -------
--|----
 */
//先计算两链表长度 如果有公共点那他俩结束位置肯定一致   从可能的公共点同时开始遍历到结束的位置 即竖线位置
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int numA = 0;
        int numB = 0;
        for(ListNode i = headA; i != null; i = i.next){
            numA++;
        }
        for(ListNode i = headB; i != null; i = i.next){
            numB++;
        }
        if(numA > numB) {
            while (numA > numB) {
                headA = headA.next;
                numA--;
            }
        }else if(numA < numB) {
            while (numA < numB) {
                headB = headB.next;
                numB--;
            }
        }

        for(ListNode a = headA,b = headB; a != null; a = a.next ,b = b.next){
            if(a == b){
                return a;
            }
        }
        return null;


    }
}

/*
//原理 两种排列方式 链表长度和相等 总会同时结束 和上面做法其实等价
- ——
—— -
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}
* */