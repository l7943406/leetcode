package P888公平的糖果棒交换;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    //二分查找
    public int[] fairCandySwap_1(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int less = (sumA - sumB) / 2;
        Arrays.sort(B);
        for(int i : A){
            if(Arrays.binarySearch(B,i - less) < 0){

               return new int[]{i , i - less};
            }
        }
        return null;
    }
    //哈希表
    public int[] fairCandySwap_2(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int less = (sumA - sumB) / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : A){
            map.put(i , 0);
        }
        for(int i : B){
            if(map.containsKey(i - less)){
                return new int[]{i , i - less};
            }
        }
        return null;
    }
    //双指针
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int less = (sumA - sumB) / 2;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        int j = 0;
        while(i < A.length&&j<B.length){
            if(A[i] - B[j] < less){
                i++;
            }else if(A[i] - B[j] > less){
                j++;
            }else{
                return new int[]{A[i],B[i]};
            }
        }
        return null;
    }


}