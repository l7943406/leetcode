package P981基于时间的键值存储;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

class TimeMap {
    HashMap<String, TreeMap<Integer,String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).put(timestamp,value);
        }else{
            map.put(key,new TreeMap<Integer,String>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            }));
            map.get(key).put(timestamp,value);
        }
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            for (int next : map.get(key).keySet()) {
                if (next <= timestamp) {
                    return map.get(key).get(next);
                }
            }
        }
        return "";

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */