package P430扁平化多级双向链表;


import java.util.Deque;
import java.util.LinkedList;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class Solution {
    Deque<Node> deque = new LinkedList<>();
    public Node flatten(Node head) {
        if(head == null){
            return null;
        }
        dfs(head);
        Node last = deque.pollFirst();
        last.child = null;
        last.next = null;
        last.prev = null;
        while (!deque.isEmpty()){
            Node node = deque.pollFirst();
            last.next = node;
            node.prev = last;
            node.next = null;
            node.child = null;
            last = node;
        }

        return head;
    }

    private void dfs(Node head){
        if(head == null){
            return;
        }
        deque.add(head);
        if (head.child != null) {
            dfs(head.child);
        }
        dfs(head.next);
    }


}