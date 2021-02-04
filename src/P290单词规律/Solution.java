package P290单词规律;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split=s.split((" "));
        if(pattern.length() != split.length){
            return false;
        }
        Map<String,Character> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(split[i])){
                map.put(split[i],pattern.charAt(i));
            }else{
                if(map.get(split[i]) != pattern.charAt(i)){
                    return false;
                }
            }
        }

        Map<Character,String> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!map2.containsKey(pattern.charAt(i))) {
                map2.put(pattern.charAt(i), split[i]);
            } else {
                if (map2.get(pattern.charAt(i)).compareTo(split[i]) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}