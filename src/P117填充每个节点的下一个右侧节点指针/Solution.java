package P117填充每个节点的下一个右侧节点指针;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};



class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }











        return root;
    }
}