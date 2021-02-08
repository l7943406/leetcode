package P978最长湍流子数组;

class Solution {
    int[] arr;
    public int maxTurbulenceSize(int[] arr){
        this.arr = arr;
        return solve(0);
    }
    /**
     * @param start:下一次查找最长湍流子数组的起点
     * @return 最长湍流子数组的长度
     * **/
    int solve(int start){
        //标记上次是小于号还是大于号
        boolean lastIsLess = false;
        //初始化lr为起点start
        int end = start;
        for (end = start; end < arr.length - 1; end++) {
            //如果是起点就先初始化lastIsLess
            if(end == start){
                if(arr[end] < arr[end+1]){
                    lastIsLess = true;
                }else if(arr[end] > arr[end+1]){
                    lastIsLess = false;
                }else{
                    //如果第一次就遇见等于号就直接递归查找下一位置
                    //例如：131313112121，当遇见1==1时，让下一位置直接从第二个1开始就行
                    return Math.max(1,solve(end + 1));
                }
            }else{
                //如果上一个符号是小于号
                if(lastIsLess){
                    //如果符合湍流数组条件，翻转lastIsLess继续往后找
                    if(arr[end] > arr[end + 1]){
                        lastIsLess = false;
                    }
                    //如果不符合条件，则从下一可能开始的位置开始查找
                    else if(arr[end] < arr[end + 1]){
                        return Math.max(end - start + 1,solve(end));
                    }else{
                        return Math.max(end - start + 1,solve(end + 1));
                    }
                }
                //上个符号是大于号
                else{
                    //如果符合湍流数组条件，翻转lastIsLess继续往后找
                    if(arr[end] < arr[end + 1]){
                        lastIsLess = true;
                    }
                    //如果不符合条件，则从下一可能开始的位置开始查找
                    else if(arr[end] > arr[end + 1]){
                        return Math.max(end - start + 1,solve(end));
                    }else{
                        return Math.max(end - start + 1,solve(end + 1));
                    }
                }
            }
        }
        //如果数组循环到最后一位还符合就返回end - start + 1
        return end - start + 1;
    }
}