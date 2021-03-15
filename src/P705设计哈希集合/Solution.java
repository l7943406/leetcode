package P705设计哈希集合;


class MyHashSet {
    Node[] node;
    int prim;
    public MyHashSet() {
        prim = 9697;
        node = new Node[prim];
    }
    public void add(int key) {
        int prKey = key % prim;
        if(node[prKey] == null){
            node[prKey] = new Node(key,null,null);
        }else{
            Node t = node[prKey];
            if(t.key == key){
                return;
            }
            while(t.next != null){
                t = t.next;
                if(t.key == key){
                    return;
                }
            }
            t.next = new Node(key,t,null);
        }
    }
    public boolean contains(int key) {
        int prKey = key % prim;
        Node t = node[prKey];
        while (t!=null){
            if(t.key == key){
                return true;
            }
            t = t.next;
        }
        return false;
    }
    public void remove(int key) {
        int prKey = key % prim;
        Node t = node[prKey];
        if(t == null){
            return;
        }
        if(t.key == key){
            if(t.next == null){
                node[prKey] = null;
                return;
            }else{
                t.next.last = null;
                node[prKey] = t.next;
                return;
            }
        }
        while (t.next != null){
            t = t.next;
            if(t.key == key){
                t.last.next = t.next;
                if(t.next != null){
                    t.next.last = t.last;
                }
                return;
            }
        }
    }
    class Node{
        int key;
        Node next;
        Node last;
        public Node(){

        }
        public Node(int key, Node last, Node next){
            this.key = key;
            this.last = last;
            this.next = next;
        }
    }
}