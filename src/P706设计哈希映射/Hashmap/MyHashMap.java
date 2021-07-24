//package P706设计哈希映射.Hashmap;
//
//import java.util.*;
//
//class MyHashMap {
//
//
//    class HashMap<K,V> implements Map<K,V>{
//
//
//
//        private static final int DEFAULT_CAPACITY = 16;
//        private static final double DEFAULT_LOAD_FACTORY = 0.75;
//        private static final int MAX_CAPACITY = 1 << 30;
//
//
//
//        private transient Node<K,V>[] nodes;
//        private transient int size;
//        private transient int capacity;
//        private transient double loadFactor;
//
//        public HashMap(int capacity,double loadFactor){
//            if (capacity < 0) {
//                throw new IllegalArgumentException("Illegal initial capacity: " + capacity);
//            }
//            if (capacity > MAX_CAPACITY) {
//                capacity = MAX_CAPACITY;
//            }
//            if (loadFactor <= 0 || Double.isNaN(loadFactor)) {
//                throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
//            }
//            this.nodes = new Node[tableSizeFor(capacity) << 1];
//            this.capacity = tableSizeFor(capacity) << 1;
//            this.loadFactor = loadFactor;
//        }
//        public HashMap(int capacity){
//            this(capacity,DEFAULT_LOAD_FACTORY);
//        }
//        public HashMap(){
//            this(0,DEFAULT_CAPACITY);
//        }
//
//
//        private void reHash(){
//            int newCapacity = tableSizeFor(capacity) << 1;
//            Node<K,V>[] newNodes = new Node[newCapacity];
//
//
//            for (int i = 0; i < capacity; i++) {
//                Node<K,V> node = nodes[i];
//                Node<K,V> next;
//                while (node != null){
//                    next = node.next;
//                    node.next = null;
//
//                    int hash = node.hash;
//                    int index = hash & (newCapacity - 1);
//
//                    if (newNodes[index] != null) {
//                        node.next = newNodes[index];
//                    }
//                    newNodes[index] = node;
//
//                    node = next;
//                }
//            }
//
//            this.capacity = newCapacity;
//            this.nodes = newNodes;
//        }
//
//        private class Node<K,V> implements Entry<K,V>{
//            final K key;
//            final int hash;
//            V value;
//            Node<K,V> next;
//
//
//
//            public Node(K key,V value,int hash,Node<K,V> next){
//                this.key = key;
//                this.value = value;
//                this.hash = hash;
//                this.next = next;
//            }
//
//            @Override
//            public K getKey() {
//                return key;
//            }
//
//            @Override
//            public V getValue() {
//                return value;
//            }
//
//            @Override
//            public V setValue(V value) {
//                V oldValue = this.value;
//                this.value = value;
//                return oldValue;
//            }
//
//            @Override
//            public final boolean equals(Object other){
//                if(other == this){
//                    return true;
//                }else{
//                    if(other instanceof Node){
//                        if(Objects.equals(this.key,((Node<?, ?>) other).key) &&
//                                Objects.equals(this.value,((Node<?, ?>) other).value)){
//                            return true;
//                        }
//                    }
//                }
//                return false;
//            }
//        }
//
//        int hash(Object key){
//            return key.hashCode();
//        }
//
//
//         int tableSizeFor(int cap) {
//            int n = cap - 1;
//            n |= n >>> 1;
//            n |= n >>> 2;
//            n |= n >>> 4;
//            n |= n >>> 8;
//            n |= n >>> 16;
//            return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
//        }
//
//
//
//        @Override
//        public int size() {
//            return size;
//        }
//
//        @Override
//        public boolean isEmpty() {
//            return size == 0;
//        }
//
//
//        @Override
//        public boolean containsKey(Object key) {
//            return getNode(key) != null;
//        }
//
//        private Node<K,V> getNode(Object key){
//            int hash = hash(key);
//            int index = hash & (capacity - 1);
//            Node<K,V> node = nodes[index];
//            while (node != null){
//                if(node.hash == hash && Objects.equals(node.key,key)){
//                    return node;
//                }
//                node = node.next;
//            }
//            return null;
//        }
//
//        @Override
//        public boolean containsValue(Object value) {
//            for (int i = 0; i < capacity; i++) {
//                Node<K,V> node = nodes[i];
//                while (node != null){
//                    if(Objects.equals(node.value,value)){
//                        return true;
//                    }
//                    node = node.next;
//                }
//            }
//            return false;
//        }
//
//
//        @Override
//        public V get(Object key) {
//            Node<K, V> node = getNode(key);
//            return node == null ? null : node.getValue();
//        }
//
//        void tryExpansionCapacity(){
//            if(size >= loadFactor * capacity || nodes == null){
//                reHash();
//            }
//        }
//
//        @Override
//        public V put(K key, V value) {
//            tryExpansionCapacity();
//            int hash = hash(key);
//            int index = hash & (capacity - 1);
//
//            if(nodes[index] == null){
//                nodes[index] = new Node<>(key,value,hash,null);
//                size++;
//                return null;
//            }else{
//                Node<K, V> node = nodes[index];
//                Node<K, V> lastNode = nodes[index];
//
//                while (node != null){
//                    if(node.hash == hash && Objects.equals(node.key,key)){
//                        V oldValue = node.getValue();
//                        node.setValue(value);
//                        return oldValue;
//                    }
//                    lastNode = node;
//                    node = node.next;
//                }
//
//                size++;
//                lastNode.next = new Node<>(key,value,hash,null);
//                return value;
//            }
//        }
//
//        @Override
//        public V remove(Object key) {
//            int hash = hash(key);
//            int index = hash & (capacity - 1);
//            if(size == 0 || nodes[index] == null){
//                return null;
//            }else if(nodes[index].hash == hash && Objects.equals(nodes[index].key,key)){
//                V oldValue = nodes[index].getValue();
//                nodes[index] = nodes[index].next;
//                size--;
//                return oldValue;
//            }else{
//                Node<K,V> node = nodes[index];
//                while (node.next != null){
//                    if(node.next.hash == hash && Objects.equals(node.next.key,key)){
//                        V oldValue = node.next.getValue();
//                        node.next = node.next.next;
//                        size--;
//                        return oldValue;
//                    }
//                }
//            }
//            return null;
//        }
//
//        @Override
//        public void putAll(java.util.Map<? extends K, ? extends V> m) {
//            for(Entry<? extends K, ? extends V> entry : m.entrySet()){
//                put(entry.getKey(),entry.getValue());
//            }
//        }
//
//        @Override
//        public void clear() {
//            this.size = 0;
//            for (int i = 0; i < capacity; i++) {
//                Node<K,V> node = nodes[i],t;
//                while (node.next != null){
//                    t = node.next;
//                    node.next = null;
//                    node = t;
//                }
//                nodes[i] = null;
//            }
//        }
//
//        @Override
//        public Set<K> keySet() {
//            return new HashSet<>();
//        }
//
//        @Override
//        public Collection<V> values() {
//            return new ArrayList<>();
//        }
//
//        @Override
//        public Set<Entry<K, V>> entrySet() {
//            return new HashSet<>();
//        }
//    }
//
//    HashMap<Integer,Integer> map = new HashMap<>();
//    /** Initialize your data structure here. */
//    public MyHashMap() {
//
//    }
//
//    /** value will always be non-negative. */
//    public void put(int key, int value) {
//        map.put(key,value);
//    }
//
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    public int get(int key) {
//        Integer result = map.get(key);
//        return result == null ? -1 : result;
//    }
//
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    public void remove(int key) {
//        map.remove(key);
//    }
//
//
//}
//
///**
// * Your MyHashMap object will be instantiated and called as such:
// * MyHashMap obj = new MyHashMap();
// * obj.put(key,value);
// * int param_2 = obj.get(key);
// * obj.remove(key);
// */
