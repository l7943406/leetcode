package P1713得到子序列的最少操作次数;

import java.util.*;

class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>(target.length);
        for (int i = 0; i < target.length; i++) {
            map.put(target[i],i);
            target[i] = i;
        }

        boolean flag = true;
        int[] queue = new int[target.length];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.getOrDefault(arr[i],-1);
            if(flag && arr[i] != -1){
                flag = false;
                queue[0] = arr[i];
                index = i;
            }
        }
        if(flag){
            return target.length;
        }

        int i = index + 1;
        index = 1;

        for(; i < arr.length; i++){
            int num = arr[i];
            if(num == -1){
                continue;
            }
            int l = 0,r = index;
            while (l < r){
                int m = (l + r) / 2;
                if(queue[m] < num){
                    l = m + 1;
                }else{
                    r = m;
                }
            }
            queue[l] = num;
            if(index == r){
                index++;
            }
        }


        return target.length - index;
    }
}
/*
给你一个数组target，包含若干 互不相同的整数，以及另一个整数数组arr，arr可能 包含重复元素。

每一次操作中，你可以在 arr的任意位置插入任一整数。比方说，如果arr = [1,4,1,2]，那么你可以在中间添加 3得到[1,4,3,1,2]。你可以在数组最开始或最后面添加整数。

请你返回 最少操作次数，使得target成为arr的一个子序列。

一个数组的 子序列指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4]是[4,2,3,7,2,1,4]的子序列（加粗元素），但[2,4,2]不是子序列。
* */