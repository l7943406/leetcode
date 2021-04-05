package P88合并两个有序数组;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(nums1,0,m,nums2[i]);
            if(index < 0){
                double index2 = - index - 1.5;
                if(index2 > m){
                    nums1[m] = nums2[i];
                }else{
                    for (int j = m - 1; j >= index2; j--) {
                        nums1[j + 1] = nums1[j];
                    }
                    nums1[(int)(index2+0.5)] = nums2[i];
                }
            }else{
                System.arraycopy(nums1, index, nums1, index + 1, m - index);
                nums1[index] = nums2[i];
            }
            m++;
        }
    }
}