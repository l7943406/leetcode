package P1114按序打印;

class Foo {
    public static boolean isOne;
    public static boolean isTwo;

    public Foo() {
        isOne = false;
        isTwo = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        isOne = true;
        this.notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(!isOne){
            this.wait();
        }
        printSecond.run();
        isTwo = true;
        this.notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(!isTwo){
            this.wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}