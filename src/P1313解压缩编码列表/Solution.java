package P1313解压缩编码列表;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Solution {
    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i+=2) {
            length += nums[i];
        }
        int [] ans = new int[length];
        int t = 0;
        for (int i = 0; i < nums.length; i+=2) {
            for(int j = 0; j <nums[i] ;j++){
                ans[t++] = nums[i+1];
            }
        }
        return ans;
    }
}