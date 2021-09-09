package P1754构造字典序最大的合并字符串;

class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        byte[] s1 = word1.getBytes();
        byte[] s2 = word2.getBytes();
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.length && i2 < s2.length){
            if(s1[i1] > s2[i2]){
                ans.append((char) s1[i1++]);
            }else if(s1[i1] < s2[i2]){
                ans.append((char) s2[i2++]);
            }else{
                int count = 0;
                while (i1 < s1.length && i2 < s2.length && s1[i1] == s2[i2]){
                    ans.append((char) s1[i1]);
                    i1++;
                    i2++;
                    count++;
                }
                if(i1 < s1.length && i2 < s2.length){
                    if(s1[i1] < s2[i2]){
                        i1 -= count;
                    }else if(s1[i1] > s2[i2]){
                        i2 -= count;
                    }
                }else if(i1 < s1.length){
                    byte c = s1[i1 - 1];
                    while (i1 < s1.length && c == s1[i1]){
                        ans.append((char) s1[i1++]);
                    }
                    i2 -= count;
                }else if(i2 < s2.length){
                    byte c = s2[i2 - 1];
                    while (i2 < s2.length && c == s2[i2]){
                        ans.append((char) s2[i2++]);
                    }
                    i1 -= count;
                }else{
                    int in = i1 - 1;
                    for (int i = 0; i < count; i++) {
                        ans.append((char) s1[in]);
                    }
                    return ans.toString();
                }

            }

        }

        if(i1 < s1.length){
            while (i1 < s1.length){
                ans.append((char) s1[i1++]);
            }
        }
        if(i2 < s2.length){
            while (i2 < s2.length){
                ans.append((char) s2[i2++]);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestMerge("qqqqqqqqqeqeqqeeqqq", "qqqqqqqqeqqqeeqqeeqqqqqeq"));
    }
}
/*
给你两个字符串 word1 和 word2 。你需要按下述方式构造一个新字符串 merge ：如果 word1 或 word2 非空，选择 下面选项之一 继续操作：

如果 word1 非空，将 word1 中的第一个字符附加到 merge 的末尾，并将其从 word1 中移除。
例如，word1 = "abc" 且 merge = "dv" ，在执行此选项操作之后，word1 = "bc" ，同时 merge = "dva" 。
如果 word2 非空，将 word2 中的第一个字符附加到 merge 的末尾，并将其从 word2 中移除。
例如，word2 = "abc" 且 merge = "" ，在执行此选项操作之后，word2 = "bc" ，同时 merge = "a" 。
返回你可以构造的字典序 最大 的合并字符串 merge 。

长度相同的两个字符串 a 和 b 比较字典序大小，如果在 a 和 b 出现不同的第一个位置，a 中字符在字母表中的出现顺序位于 b 中相应字符之后，就认为字符串 a 按字典序比字符串 b 更大。例如，"abcd" 按字典序比 "abcc" 更大，因为两个字符串出现不同的第一个位置是第四个字符，而 d 在字母表中的出现顺序位于 c 之后。
 */

/*
cabaa
bcaaa


"qqqqqqqqqeqeqqeeqqq"
"qqqqqqqqeqqqeeqqeeqqqqqeq"

"qqqqqqqqqqqqqqqqeqqqeqeqqeeqqqqeeqqeeqqqqqeq"
"qqqqqqqqqqqqqqqqqeqqqeqeqqeeqqqeeqqeeqqqqqeq"
 */