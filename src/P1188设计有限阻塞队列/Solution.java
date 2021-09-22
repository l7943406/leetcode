package P1188设计有限阻塞队列;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {
    private final Queue<Integer> objQueue;
    private final int capacity;
    private final ReentrantLock lock;
    private final Condition consumer;
    private final Condition producer;

    public BoundedBlockingQueue(int capacity) {
        objQueue = new LinkedList<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.consumer = this.lock.newCondition();
        this.producer = this.lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (objQueue.size() >= capacity){
                producer.await();
            }
            objQueue.add(element);
            consumer.signal();
        }finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (objQueue.isEmpty()){
                consumer.await();
            }
            Integer ans = objQueue.poll();
            producer.signal();
            return ans;
        }finally {
            lock.unlock();
        }
    }

    public int size() {
        return objQueue.size();
    }
}