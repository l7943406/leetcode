package P83删除排序链表中的重复元素;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ln;
        ln=head;
        while(ln!=null&&ln.next!=null){
            if(ln.next.val!=ln.val){
                ln=ln.next;
            }
            else{
                if(ln.next.next==null){
                    ln.next=null;
                }
                else{
                    ln.next=ln.next.next;
                }
            }
        }
        return head;
    }
}