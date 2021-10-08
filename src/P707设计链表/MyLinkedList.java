package P707设计链表;

/**
 * @author muchen
 */
public class MyLinkedList {
    static class Node{
        int val;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node head;
    private final Node tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(-1, null, null);
        tail = new Node(-1, null, null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.val;
    }

    private Node getNode(int index){
        if(index >= size || index < 0){
            return null;
        }
        if(size - index > index + 1){
            Node tmp = head.next;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        }else{
            Node tmp = tail.prev;
            int n = size - index - 1;
            for (int i = 0; i < n; i++) {
                tmp = tmp.prev;
            }
            return tmp;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        size++;
        Node node = new Node(val, this.head, this.head.next);
        node.prev.next = node;
        node.next.prev = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        size++;
        Node node = new Node(val, this.tail.prev, this.tail);
        node.prev.next = node;
        node.next.prev = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
       if(index == size){
           addAtTail(val);
       }else if(index < 0){
           addAtHead(val);
       }else if(index < size){
           Node newNode = new Node(val, null, null);
           Node node = getNode(index);
           newNode.next = node;
           newNode.prev = node.prev;
           newNode.prev.next = newNode;
           newNode.next.prev = newNode;
           size++;
       }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node node = getNode(index);
        if(node == null){
            return;
        }
        size --;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


}
