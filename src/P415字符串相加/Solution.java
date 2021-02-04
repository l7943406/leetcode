package P415字符串相加;

import java.math.BigInteger;

class Solution {
    public String addStrings(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        return a.add(b).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("4564564","415646546546"));
    }
}