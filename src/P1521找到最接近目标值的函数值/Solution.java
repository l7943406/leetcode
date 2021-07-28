package P1521找到最接近目标值的函数值;

import java.util.Random;

class Solution {
    public int closestToTarget(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(Math.abs(target - num) < ans){
                    ans = Math.abs(target - num);
                }
                num &= arr[j];
            }
            if(Math.abs(target - num) < ans){
                ans = Math.abs(target - num);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt();
        }
        System.out.println(new Solution().closestToTarget(arr, 100));
    }
}

/*


Winston 构造了一个如上所示的函数func。他有一个整数数组arr和一个整数target，他想找到让|func(arr, l, r) - target|最小的 l和 r。

请你返回|func(arr, l, r) - target|的最小值。

请注意，func 的输入参数l 和r需要满足0 <= l, r < arr.length。
1 2 3 4 56 7489 749 84789 489

 */