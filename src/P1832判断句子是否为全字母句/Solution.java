package P1832判断句子是否为全字母句;

import java.nio.charset.StandardCharsets;

class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] map = new int[26];
        for(byte c : sentence.getBytes(StandardCharsets.UTF_8)){
            map[c - 'a'] ++;
        }
        for(int m : map){
            if(m == 0){
                return false;
            }
        }
        return true;
    }
}
/*

全字母句 指包含英语字母表中每个字母至少一次的句子。

给你一个仅由小写英文字母组成的字符串 sentence ，请你判断sentence 是否为 全字母句 。

如果是，返回 true ；否则，返回 false 。

 */