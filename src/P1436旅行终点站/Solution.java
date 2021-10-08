package P1436旅行终点站;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>(256);
        for(List<String> path : paths){
            map.put(path.get(0), null);
        }
        for(List<String> path : paths){
            if(!map.containsKey(path.get(1))){
                return path.get(1);
            }
        }
        return null;
    }
}