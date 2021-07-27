package P349两个数组的交集;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        Map<Integer,Object> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        Object obj = new Object();
        for (int num : nums1) {
            map.put(num,obj);
        }
        for(int num : nums2){
            if(map.getOrDefault(num,null) != null){
                list.add(num);
                map.put(num,null);
            }
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for(int i : list){
            ans[index ++] = i;
        }
        return ans;
    }
}