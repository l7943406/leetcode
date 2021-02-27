package P1178猜字谜;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ans = new LinkedList<>();
        for(String s : words){
            int mask = getBitMask(s);
            if(Integer.bitCount(mask) <= 7){
                map.put(mask,map.getOrDefault(mask,0) + 1);
            }
        }
        for (String puzzle : puzzles) {
            int cnt = 0;
            int first = getBitMask(puzzle.substring(0, 1));
            int mask = getBitMask(puzzle.substring(1));
            int subset = mask;
            while (subset != 0) {
                int key = first | subset;
                if (map.containsKey(key)) {
                    cnt += map.get(key);
                }
                subset = (subset - 1) & mask;
            }
            if (map.containsKey(first)) {
                cnt += map.get(first);
            }
            ans.add(cnt);
        }
        return ans;
    }

    public int getBitMask(String word) {
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            mask |= (1 << (ch - 'a'));
        }
        return mask;
    }


}