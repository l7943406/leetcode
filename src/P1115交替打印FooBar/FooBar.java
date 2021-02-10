package P1115交替打印FooBar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    //now1foo now2bar
    private int now;
    private int n;
    private Lock lock;
    private Condition conditionFoo;
    private Condition conditionBar;
    public FooBar(int n) {
        this.now = 1;
        this.n = n;
        this.lock = new ReentrantLock();
        this.conditionFoo = lock.newCondition();
        this.conditionBar = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while(now == 2){
                    conditionFoo.await();
                }
                printFoo.run();
                now = 2;
                conditionBar.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while(now == 1){
                    conditionBar.await();
                }
                printBar.run();
                now = 1;
                conditionFoo.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}