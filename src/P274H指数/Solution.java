package P274H指数;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for(int i = citations.length - 1; i >= 0; i--){
            if(citations.length - i >= citations[i]){
                max = Math.max(max,citations[i]);
            }else if(i == 0 || citations[i - 1] != citations[i]){
                max = Math.max(max,citations.length - i);
            }
        }
        return max;
    }
}