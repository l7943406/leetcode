package P1282用户分组;

import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map= new HashMap<>();
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i],new LinkedList<>());
            }
            map.get(groupSizes[i]).add(i);
        }
        Set<Integer> set = map.keySet();
        for(int i : set){
            List<Integer> fromMap = map.get(i);
            if(fromMap.size() == i){
                ans.add(fromMap);
            }else{
                for (int j = 0; j < fromMap.size() / i; j++) {
                    List<Integer> list = new LinkedList<>();
                    for (int k = j * i; k < (j + 1)  * i; k++) {
                        list.add(fromMap.get(k));
                    }
                    ans.add(list);
                }

            }
        }
        return ans;
    }
}