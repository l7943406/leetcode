package P1743从相邻元素对还原数组;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] ans = new int[adjacentPairs.length + 1];
        Map<Integer,Integer>[] maps = new Map[3];
        maps[0] = new HashMap<>(adjacentPairs.length);
        maps[1] = new HashMap<>(adjacentPairs.length);
        maps[2] = new HashMap<>(adjacentPairs.length);



        for (int[] adjacentPair : adjacentPairs) {
            for (Map<Integer, Integer> map : maps) {
                if (!map.containsKey(adjacentPair[0])) {
                    map.put(adjacentPair[0], adjacentPair[1]);
                    break;
                }
            }
            for (Map<Integer, Integer> map : maps) {
                if (!map.containsKey(adjacentPair[1])) {
                    map.put(adjacentPair[1], adjacentPair[0]);
                    break;
                }
            }
        }

        int start = 0;
        for (int[] adjacentPair : adjacentPairs) {
            int num0 = 0;
            int num1 = 0;
            for(Map<Integer,Integer> map : maps){
                if(map.containsKey(adjacentPair[0])){
                    num0 ++;
                }
                if(map.containsKey(adjacentPair[1])){
                    num1 ++;
                }
            }
            if (num0 == 1) {
                start = adjacentPair[0];
                break;
            } else if (num1 == 1) {
                start = adjacentPair[1];
                break;
            }
        }

        int index = 0;
        ans[index ++] = start;
        int last = Integer.MAX_VALUE;
        while (index < adjacentPairs.length + 1){
            int[] next = new int[2];
            int end = 0;
            for(Map<Integer,Integer> map : maps){
                Integer g = map.get(start);
                if(g != null){
                    next[end ++] = g;
                }
            }
            if(next[0] != last){
                last = start;
                start = next[0];
            }else{
                last = start;
                start = next[1];
            }

            ans[index ++] = start;
        }
        return ans;
    }


}