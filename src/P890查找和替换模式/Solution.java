package P890查找和替换模式;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new LinkedList<>();
        int code = mode(pattern);
        for (String word : words) {
            if (code == mode(word)) {
                ans.add(word);
            }
        }
        return ans;

    }
    private int mode(String string){
        byte[] s = string.getBytes();
        byte[] b = new byte[26];
        byte index = 1;
        int code = 0;
        for (int i = 0; i < s.length; i++) {
            if(b[s[i] - 'a'] == 0){
                b[s[i] - 'a'] = index++;
            }
            s[i] = b[s[i] - 'a'];
            code = 31 * code + s[i];
        }


        return code;
    }
}



/*

你有一个单词列表words和一个模式pattern，你想知道 words 中的哪些单词与模式匹配。

如果存在字母的排列 p，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。

（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）

返回 words 中与给定模式匹配的单词列表。

你可以按任何顺序返回答案。

 */