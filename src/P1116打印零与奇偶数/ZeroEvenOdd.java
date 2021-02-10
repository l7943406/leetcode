package P1116打印零与奇偶数;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private int i;
    private boolean hadZero;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.i = 1;
        this.hadZero = false;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while(hadZero&&i!=n+1){
            this.wait();
        }
        if(i == n+1){
            return;
        }
        printNumber.accept(0);
        hadZero = true;
        this.notifyAll();
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while((!hadZero||i%2==1)&&i!=n+1){
            this.wait();
        }
        if(i == n+1){
            return;
        }
        printNumber.accept(i);
        i++;
        hadZero = false;
        this.notifyAll();
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while((!hadZero||i%2==0)&&i!=n+1){
            this.wait();
        }
        if(i == n+1){
            return;
        }
        printNumber.accept(i);
        i++;
        hadZero = false;
        this.notifyAll();
    }

    public static void main(String[] args) {
        int n = 100000;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        new Thread(()->{
            for (int i = 0; i < n; i++) {
                try {
                    zeroEvenOdd.odd(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < n; i++) {
                try {
                    zeroEvenOdd.zero(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < n; i++) {
                try {
                    zeroEvenOdd.even(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}