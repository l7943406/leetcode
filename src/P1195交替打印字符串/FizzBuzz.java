package P1195交替打印字符串;

import java.lang.ref.PhantomReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int num;
    private int now;
    private Lock lock;
    //now 1
    private Condition conditionFizz;
    //now 2
    private Condition conditionBuzz;
    //now 3
    private Condition conditionFizzBuzz;
    //now 4
    private Condition conditionNumber;


    public FizzBuzz(int n) {
        this.n = n;
        this.num = 1;
        this.lock = new ReentrantLock();
        this.conditionFizz = lock.newCondition();
        this.conditionBuzz = lock.newCondition();
        this.conditionFizzBuzz = lock.newCondition();
        this.conditionNumber = lock.newCondition();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if(i%3==0 && i%5!=0){
                lock.lock();
                try {
                    while(num!=i){
                        conditionFizz.await();
                    }
                    printFizz.run();
                    num ++;
                    if(num % 3==0&&num%5==0){
                        conditionFizzBuzz.signalAll();
                    }else if(num%3 ==0){
                        conditionFizz.signalAll();
                    }else if(num%5 ==0){
                        conditionBuzz.signalAll();
                    }else{
                        conditionNumber.signalAll();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if(i%5==0 && i%3!=0){
                lock.lock();
                try {
                    while(num!=i){
                        conditionBuzz.await();
                    }
                    printBuzz.run();
                    num ++;
                    if(num % 3==0&&num%5==0){
                        conditionFizzBuzz.signalAll();
                    }else if(num%3 ==0){
                        conditionFizz.signalAll();
                    }else if(num%5 ==0){
                        conditionBuzz.signalAll();
                    }else{
                        conditionNumber.signalAll();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if(i%3==0 && i%5 ==0){
                lock.lock();
                try {
                    while(num!=i){
                        conditionFizzBuzz.await();
                    }
                    printFizzBuzz.run();
                    num ++;
                    if(num % 3==0&&num%5==0){
                        conditionFizzBuzz.signalAll();
                    }else if(num%3 ==0){
                        conditionFizz.signalAll();
                    }else if(num%5 ==0){
                        conditionBuzz.signalAll();
                    }else{
                        conditionNumber.signalAll();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if(i%3!=0 && i%5!=0){
                lock.lock();
                try {
                    while(num!=i){
                        conditionNumber.await();
                    }
                    printNumber.accept(i);
                    num ++;
                    if(num % 3==0&&num%5==0){
                        conditionFizzBuzz.signalAll();
                    }else if(num%3 ==0){
                        conditionFizz.signalAll();
                    }else if(num%5 ==0){
                        conditionBuzz.signalAll();
                    }else{
                        conditionNumber.signalAll();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}