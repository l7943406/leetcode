package P833字符串中的查找与替换;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder ans = new StringBuilder();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i],i);
        }

        byte[] b = s.getBytes();
        for (int i = 0; i < b.length; ) {
            Integer index = map.get(i);
            if(index != null){
                if(i + sources[index].length() > b.length){
                    ans.append((char)b[i]);
                    i++;
                    continue;
                }
                boolean flag = false;
                for (int j = 0; j < sources[index].length(); j++) {
                    if(b[j + i] != sources[index].charAt(j)){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    ans.append((char)b[i]);
                    i++;
                    continue;
                }

                ans.append(targets[index]);

                i += sources[index].length();
            }else{
                ans.append((char)b[i]);
                i++;
            }
        }
        return ans.toString();
    }
}
/*
某个字符串 S 需要执行一些替换操作，用新的字母组替换原有的字母组（不一定大小相同）。

每个替换操作具有 3 个参数：起始索引 i，源字 x 和目标字 y。规则是：如果 x 从原始字符串 S 中的位置 i 开始，那么就用 y 替换出现的 x。如果没有，则什么都不做。

举个例子，如果 S= “abcd” 并且替换操作 i = 2，x = “cd”，y = “ffff”，那么因为 “cd” 从原始字符串 S 中的位置 2 开始，所以用“ffff” 替换它。

再来看 S = “abcd” 上的另一个例子，如果一个替换操作 i = 0，x = “ab”，y = “eee”，以及另一个替换操作 i = 2，x = “ec”，y = “ffff”，那么第二个操作将不会执行，因为原始字符串中S[2] = 'c'，与 x[0] = 'e' 不匹配。

所有这些操作同时发生。保证在替换时不会有任何重叠：S = "abc", indexes = [0, 1],sources = ["ab","bc"] 不是有效的测试用例。
 */