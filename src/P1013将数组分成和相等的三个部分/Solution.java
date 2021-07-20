package P1013将数组分成和相等的三个部分;

import java.util.Arrays;

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        if(arr[arr.length - 1] % 3 != 0){
            return false;
        }
        boolean s1 = false;
        boolean s2 = false;
        long index = Long.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(!s1 && arr[i] == arr[arr.length - 1] / 3){
                s1 = true;
            }else if(s1 && arr[i] == arr[arr.length - 1] / 3 * 2){
                s2 = true;
            }
            if (s1 && s2){
                index = i;
                break;
            }
        }
        return s1 && s2 && index < arr.length - 1;
    }

}