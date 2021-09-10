package P146LRU缓存机制;


import java.util.HashMap;

/**
 * @author muchen
 * lru算法 使用一个双向链表维护使用时间顺序
 * 当值被更新 / 读取时 将此节点移动到双向链表的头
 * 当空间已满时put需要删除最久未使用的节点时 从双向链表中删除链表尾 并在map中删除链表尾
 * */
class LRUCache {

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

        public Node(Node left, Node right, int key, int val){
            this.left = left;
            this.right = right;
            this.key = key;
            this.val = val;
        }
    }

    /** 保存双向链表节点的map */
    private final HashMap<Integer, Node> map;
    /** 已使用的空间大小*/
    private int size;
    /** 最大空间大小 */
    private final int capacity;
    /** 双向链表头 */
    private final Node head;
    /** 双向链表尾 */
    private final Node tail;

    /**使用capacity初始化map 和 双向链表*/
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity * 4 / 3);

        //初始化双向链表头尾
        this.head = new Node(null, null, -1, -1);
        this.tail = new Node(head, null, -1, -1);
        this.head.right = this.tail;
    }

    private void delete(){
        if(size > 0){
            map.remove(tail.left.key);
            tail.left = tail.left.left;
            tail.left.right = tail;
        }
    }

    private void update(Node node){
        //从链表中取出node节点
        node.left.right = node.right;
        node.right.left = node.left;
        add(node);
    }

    private Node add(Node node){
        //将node添加至链表的头
        node.left = head;
        node.right = head.right;
        head.right = node;
        node.right.left = node;
        return node;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.val = value;
            update(node);
        }else{
            if(size == capacity){
                delete();
            }else{
                size ++;
            }
            ;
            map.put(key , add( new Node(head, head.right, key, value)));
        }
    }

}
