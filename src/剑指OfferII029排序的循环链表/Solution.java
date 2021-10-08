package 剑指OfferII029排序的循环链表;

class Node {
    public int val;
    public Node next;
    public Node() {

    }
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
};

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node tmp = head.next;
        while (true) {
            if(tmp.next.val >= tmp.val){
                if (tmp.val <= insertVal && tmp.next.val >= insertVal) {
                    Node node = new Node(insertVal);
                    node.next = tmp.next;
                    tmp.next = node;
                    return head;
                }
            }else{
                if(tmp.val <= insertVal || insertVal <= tmp.next.val){
                    Node node = new Node(insertVal);
                    node.next = tmp.next;
                    tmp.next = node;
                    return head;
                }
            }
            if(tmp == head){
                Node node = new Node(insertVal);
                node.next = tmp.next;
                tmp.next = node;
                return head;
            }
            tmp = tmp.next;
        }

    }
}