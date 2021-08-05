package 剑指OfferII041滑动窗口的平均值;

class MovingAverage {
    int[] nums;
    int sum;
    int index;
    int size;
    int maxSize;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        nums = new int[size];
        this.sum = 0;
        this.index = 0;
        this.size = 0;
        this.maxSize = size;
    }

    public double next(int val) {
        if(size == maxSize){
            sum = sum - nums[index] + val;
            nums[index] = val;
            index ++;
            index %= maxSize;
        }else{
            sum += val;
            nums[size++] = val;
        }
        return (double) sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
/*

给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。

实现 MovingAverage 类：

MovingAverage(int size) 用窗口大小 size 初始化对象。
double next(int val)成员函数 next每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。

 */