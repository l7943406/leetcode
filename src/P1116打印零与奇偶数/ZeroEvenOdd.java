package P1116打印零与奇偶数;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private int now;
    private Lock lock;
    //now 1
    private Condition conditionZero;
    //now 2
    private Condition conditionEven;
    //now 3
    private Condition conditionOdd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.now = 1;
        this.lock = new ReentrantLock();
        this.conditionZero = lock.newCondition();
        this.conditionEven = lock.newCondition();
        this.conditionOdd = lock.newCondition();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while(now!=1){
                    conditionZero.await();
                }
                printNumber.accept(0);
                if(i%2==0){
                    now = 2;
                    conditionEven.signalAll();
                }else{
                    now = 3;
                    conditionOdd.signalAll();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <=n ; i+=2) {
            lock.lock();
            try {
                while(now!=2){
                    conditionEven.await();
                }
                printNumber.accept(i);
                now = 1;
                conditionZero.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            lock.lock();
            try {
                while(now!=3){
                    conditionOdd.await();
                }
                printNumber.accept(i);
                now = 1;
                conditionZero.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }
}