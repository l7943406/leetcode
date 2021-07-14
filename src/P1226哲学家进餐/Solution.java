package P1226哲学家进餐;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
class DiningPhilosophers {
    private int now;
    private Lock lock;
    private Condition condition0;
    private Condition condition1;
    private Condition condition2;
    private Condition condition3;
    private Condition condition4;
    public DiningPhilosophers() {
        this.now = 0;
        this.lock = new ReentrantLock();
        this.condition0 = lock.newCondition();
        this.condition1 = lock.newCondition();
        this.condition2 = lock.newCondition();
        this.condition3 = lock.newCondition();
        this.condition4 = lock.newCondition();
    }

    //02413
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        switch (philosopher){
            case 0:wantsToEat0(philosopher,pickLeftFork,pickRightFork,eat,putLeftFork,putRightFork);break;
            case 1:wantsToEat1(philosopher,pickLeftFork,pickRightFork,eat,putLeftFork,putRightFork);break;
            case 2:wantsToEat2(philosopher,pickLeftFork,pickRightFork,eat,putLeftFork,putRightFork);break;
            case 3:wantsToEat3(philosopher,pickLeftFork,pickRightFork,eat,putLeftFork,putRightFork);break;
            case 4:wantsToEat4(philosopher,pickLeftFork,pickRightFork,eat,putLeftFork,putRightFork);break;
        }

    }
    public void wantsToEat0(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException{
        lock.lock();
        try{
            while(now != 0){
                condition0.await();
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            now = 2;
            condition2.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void wantsToEat1(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException{
        lock.lock();
        try{
            while(now != 1){
                condition1.await();
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            now = 3;
            condition3.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void wantsToEat2(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException{
        lock.lock();
        try{
            while(now != 2){
                condition2.await();
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            now = 4;
            condition4.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void wantsToEat3(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException{
        lock.lock();
        try{
            while(now != 3){
                condition3.await();
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            now = 0;
            condition0.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void wantsToEat4(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException{
        lock.lock();
        try{
            while(now != 4){
                condition4.await();
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            now = 1;
            condition1.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}*/
class DiningPhilosophers {
    AtomicInteger lock ;
    public DiningPhilosophers() {
        lock = new AtomicInteger(1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while (!lock.compareAndSet(1,0));
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        lock.compareAndSet(0,1);
    }
}