package P143重排链表;



public class Solution2 {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode midl = getMid(head);
        ListNode mid = midl.next;
        midl.next = null;
        ListNode head2 = reserve(mid);
        merge(head, head2);
    }

    private ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            fast = fast.next;
            if(fast == null){
                break;
            }
            fast = fast.next;
            if(fast == null){
                break;
            }
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reserve(ListNode head){
        ListNode ans = new ListNode();
        while (head != null){
            ListNode t = head.next;
            head.next = ans.next;
            ans.next = head;
            head = t;
        }
        return ans.next;
    }
    private void merge(ListNode head1, ListNode head2){
        while (head1 != null && head2 != null){
            ListNode t = head1.next;
            head1.next = head2;
            head1 = t;
            t = head2.next;
            head2.next = head1;
            head2 = t;
        }
    }

}
