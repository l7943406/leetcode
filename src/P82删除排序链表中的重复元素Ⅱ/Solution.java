package P82删除排序链表中的重复元素Ⅱ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
/*
憨憨写法， 排序排序排序链表，重复元素在一起。。。
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        HashMap<Integer,ListNode> map = new HashMap<>();
        ArrayList<ListNode> list = new ArrayList<>();
        while (head!=null){
           if(map.containsKey(head.val)){
               ListNode delete = map.get(head.val);
               if(delete != null){
                   list.remove(delete);
                   map.put(head.val,null);
               }
           }else{
               map.put(head.val,head);
               list.add(head);
           }
           head = head.next;
        }
        if(list.isEmpty()){
            return null;
        }
        head = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            head.next = list.get(i);
            head = list.get(i);
        }
        head.next = null;
        return list.get(0);
    }
}*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = head;
        ListNode last = null;
        while (t != null){
            if(t.next!= null && t.next.val == t.val){
                while (t.next != null && t.next.val == t.val){
                    t = t.next;
                }
            }else{
                if(last == null){
                    head = t;
                }else{
                    last.next = t;
                }
                last = t;
            }
            t = t.next;
        }
        if(last == null){
            return null;
        }else{
            last.next = null;
        }
        return head;
    }
}