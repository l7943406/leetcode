package P187重复的DNA序列;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** map解法 */
class Solution {
    public List<String> findRepeatedDnaSequences(String str) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        byte[] s = str.getBytes();
        for (int i = 9; i < s.length; i++) {
            String subString = new String(s,i - 9, 10);
            Integer o = map.get(subString);
            if(o == null){
                map.put(subString, 1);
            }else if(o == 1){
                result.add(subString);
                map.put(subString, 2);
            }
        }

        return result;
    }
}

/** 位运算 + 滑动窗口 */
class Solution2 {
    public List<String> findRepeatedDnaSequences(String str) {
        if(str == null || str.length() < 11){
            return new LinkedList<>();
        }
        List<String> result = new LinkedList<>();
        byte[] s = str.getBytes();
        int[] map = new int[0xfffff + 1];
        int and = 0x3ffff;
        int tmp = 0;
        Map<Byte, Integer> nums = new HashMap<>();
        nums.put((byte) 'A', 0);
        nums.put((byte) 'C', 1);
        nums.put((byte) 'G', 2);
        nums.put((byte) 'T', 3);

        for (int i = 0; i < 10; i++) {
            tmp <<= 2;
            tmp += nums.get(s[i]);
        }
        map[tmp] ++;

        for (int i = 10; i < s.length; i++) {
            tmp &= and;
            tmp <<= 2;
            tmp += nums.get(s[i]);
            if(map[tmp] == 1){
                result.add(new String(s, i - 9,10));
            }
            map[tmp] ++;
        }
        return result;
    }
}