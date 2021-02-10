package P1117H2O生成;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class H2O {
    //1 2 H / 3 O
    private int now;
    private Lock lock;
    private Condition conditionH;
    private Condition conditionO;
    public H2O() {
        this.now = 1;
        this.lock = new ReentrantLock();
        this.conditionH = lock.newCondition();
        this.conditionO = lock.newCondition();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while(now == 3){
                conditionH.await();
            }
            releaseHydrogen.run();
            now ++;
            if(now!=3){
                conditionH.signalAll();
            }else{
                conditionO.signalAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while(now != 3){
                conditionO.await();
            }
            releaseOxygen.run();
            now = 1;
            conditionH.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}