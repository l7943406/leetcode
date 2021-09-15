package P381O1时间插入删除和获取随机元素允许重复;


import java.util.*;

class RandomizedCollection {

    static class Node{
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    ArrayList<Node> list;
    HashMap<Integer, Queue<Node>> indexMap;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.list = new ArrayList<>();
        this.indexMap = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        indexMap.putIfAbsent(val, new LinkedList<>());
        Queue<Node> indexQueue = indexMap.get(val);
        Node node = new Node(list.size(), val);
        list.add(node);
        indexQueue.add(node);
        return indexQueue.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Queue<Node> queue = indexMap.get(val);
        if(queue == null || queue.isEmpty()){
            return false;
        }
        Node deleted = queue.poll();
        if(deleted.index == list.size() - 1){
            list.remove(list.size() - 1);
            return true;
        }
        Node moved = list.get(list.size() - 1);
        moved.index = deleted.index;
        deleted.val = moved.val;
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        if(list.size() == 0){
            return -1;
        }
        return list.get(new Random().nextInt(list.size())).val;
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(0);
        randomizedCollection.insert(1);
        randomizedCollection.remove(0);
        randomizedCollection.insert(2);
        randomizedCollection.remove(1);
        System.out.println(randomizedCollection.getRandom());
    }
}