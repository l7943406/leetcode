package P1389按既定顺序创建目标数组;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i],nums[i]);
        }
        int[] ans = new int[nums.length];
        Iterator<Integer> it = list.iterator();
        int t = 0;
        while(it.hasNext()){
            ans[t++] = it.next();
        }
        return ans ;
    }
}