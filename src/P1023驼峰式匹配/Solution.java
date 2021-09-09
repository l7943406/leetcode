package P1023驼峰式匹配;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>(queries.length);
        byte[] patternB = pattern.getBytes();
        for(String query : queries){
            ans.add(tryMatch( query.getBytes(), patternB));
        }
        return ans;
    }
    private boolean tryMatch(byte[] query, byte[] pattern){
        int index = 0;
        for(byte c : pattern){
            boolean flag = true;
            for (; index < query.length; index++) {
                if(query[index] == c){
                    query[index] = '?';
                    flag = false;
                    index ++;
                    break;
                }
            }
            if(flag){
                return false;
            }
        }
        for(byte c : query){
            if(c != '?'){
                if(c <= 'Z' && c >= 'A'){
                    return false;
                }
            }
        }
        return true;
    }
}