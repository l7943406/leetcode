package P706设计哈希映射;


class MyHashMap {
    Node[] node;
    int prim;
    /** Initialize your data structure here. */
    public MyHashMap() {
        prim = 9697;
        node = new Node[prim];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int prKey = key % prim;
        if(node[prKey] == null){
            node[prKey] = new Node(key,value,null,null);
        }else{
            Node t = node[prKey];
            if(t.key == key){
                t.value = value;
                return;
            }
            while(t.next != null){
                t = t.next;
                if(t.key == key){
                    t.value = value;
                    return;
                }
            }
            t.next = new Node(key,value,t,null);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int prKey = key % prim;
        Node t = node[prKey];
        while (t!=null){
            if(t.key == key){
                return t.value;
            }
            t = t.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
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
        int value;
        Node next;
        Node last;
        public Node(){

        }
        public Node(int key,int value,Node last,Node next){
            this.key = key;
            this.value = value;
            this.last = last;
            this.next = next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */