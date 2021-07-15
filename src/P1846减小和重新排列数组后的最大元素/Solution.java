package P1846减小和重新排列数组后的最大元素;

import java.util.Arrays;
import java.util.Random;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int[] sort = new int[arr.length + 1];
        for(int i : arr){
            sort[Math.min(i, arr.length)]++;
        }
        int t = 0;
        for (int i = 0; i < sort.length; i++) {
            for (int j = 0; j < sort[i]; j++) {
                arr[t ++] = i;
            }
        }
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i],arr[i - 1] + 1);
        }
        return arr[arr.length - 1];
    }
}