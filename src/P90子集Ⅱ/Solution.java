package P90子集Ⅱ;

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Map<List<Integer>,Object> map = new HashMap<>();
        Arrays.sort(nums);
        int n = get(nums.length);
        for(int i = 0 ; i <= n; i++){
            List<Integer> list = new LinkedList<>();
            String s = Integer.toBinaryString(i);
            byte[] b = new byte[nums.length - s.length()];
            s = new String(b) + s;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '1'){
                    list.add(nums[j]);
                }
            }
            if(!map.containsKey(list)){
                ans.add(list);
                map.put(list,null);
            }
        }

        return ans;
    }
    int get(int num){
        return (int)(Math.pow(2,num) - 1);
    }
}