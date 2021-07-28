package P467环绕字符串中唯一的子字符串;

class Solution {
    public int findSubstringInWraproundString(String p) {
        String s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        return 0;
    }
}

/*

把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串s 中 p 的不同的非空子串的数目。

注意: p仅由小写的英文字母组成，p 的大小可能超过 10000。

 */