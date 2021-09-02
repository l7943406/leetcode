package P1381设计一个支持增量操作的栈;

class CustomStack {
    int[] map;
    int[] stack;
    int top;
    public CustomStack(int maxSize) {
        this.map = new int[maxSize];
        this.stack = new int[maxSize];
        this.top = 0;
    }

    public void push(int x) {
        if(top < stack.length){
            stack[top ++] = x;
        }
    }

    public int pop() {
        if(top <= 0){
            return -1;
        }
        top --;
        if(top != 0){
            map[top - 1] += map[top];
        }
        int result = stack[top] + map[top];
        map[top] = 0;
        return result;
    }

    public void increment(int k, int val) {
        if(k > top){
            k = top;
        }
        if(k > 0) {
            map[k - 1] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */