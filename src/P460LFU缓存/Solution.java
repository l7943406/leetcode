package P460LFU缓存;

/**
 * TODO 未完成
 * 思路 两个hashmap 一个存储k-v
 * 一个存储使用次数对应的双向链表 维护双向链表使头为最新使用 尾为最晚使用
 *
 * */
class LFUCache {

    /** 双向链表节点 */
    static class Node{
        /** 左节点 */
        Node left;
        /** 右节点 */
        Node right;
        /** 节点key */
        int key;
        /** 节点value */
        int val;
        /** 节点使用次数 */
        int count;

        public Node(Node left, Node right, int key, int val){
            this.left = left;
            this.right = right;
            this.key = key;
            this.val = val;
        }
    }
    /** 双向链表 */
    class BidirectionalLinkedList{
        private final Node head;
        private final Node tail;
        int size;
        public BidirectionalLinkedList(){
            //初始化双向链表头尾
            this.head = new Node(null, null, -1, -1);
            this.tail = new Node(this.head, null, -1, -1);
            this.head.right = this.tail;
            this.size = 0;
        }

        public int deleteTail(){
            if(size == 0){
                return 0;
            }
            tail.left = tail.left.left;
            tail.left.right = tail;
            size--;
            return size;
        }

        public void update(Node node){

        }
    }
    public LFUCache(int capacity) {

    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }
}