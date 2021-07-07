package P43字符串相乘;

import java.util.Arrays;

class Solution {

    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0 || "0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int[] ans = new int[num1.length() * num2.length() + 1];
        byte[] str1 = num1.getBytes();
        byte[] str2 = num2.getBytes();

        int index = 0;
        for (int i = str2.length - 1; i >= 0; i--) {
            index = ans.length - 1 - (str2.length - 1 - i);
            for (int j = str1.length - 1; j >= 0; j--) {
                ans[index--] += (str1[j] - '0') * (str2[i] - '0');
            }
        }
        int carry = 0;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] += carry;
            carry = ans[i] / 10;
            ans[i] = ans[i] %10;
        }
        index = ans.length - 2;
        for (int i = 0; i < ans.length; i++) {
            if(ans[i] != 0){
                index = i;
                break;
            }
        }

        byte[] res = new byte[ans.length - index];
        for (int i = index; i < ans.length; i++) {
            res[i - index] = (byte)(ans[i] + '0');
        }
        return new String(res);
    }
}