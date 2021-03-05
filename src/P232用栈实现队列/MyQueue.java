package P232用栈实现队列;

import java.util.Stack;

class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;
    /** Initialize your data structure here. */
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(second.empty()){
            while (!first.empty()){
                second.push(first.pop());
            }
        }
        return second.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(second.empty()){
            while (!first.empty()){
                second.push(first.pop());
            }
        }
        return second.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return first.empty()&&second.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */