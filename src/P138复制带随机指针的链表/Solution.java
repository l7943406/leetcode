package P138复制带随机指针的链表;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node[] nodes = new Node[1001];
        int index = 0;
        for(Node i = head; i != null; i = i.next, index++){
            nodes[index] = new Node(i.val);
            i.val = index;
        }
        index = 0;
        for(Node i = head; i != null; i = i.next, index++){
            if(i.next != null){
                nodes[index].next = nodes[i.next.val];
            }
            if(i.random != null){
                nodes[index].random = nodes[i.random.val];
            }
        }
        return nodes[0];

    }
}