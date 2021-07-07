package P43字符串相乘;

import java.util.Arrays;

class Solution {
    byte[] ans = new byte[0];
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0 || "0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        this.ans = new byte[num1.length() * num2.length() + 1];
        byte[] product = new byte[num1.length() * num2.length() + 1];
        Arrays.fill(this.ans,(byte)'0');


        byte[] str1 = num1.getBytes();
        byte[] str2 = num2.getBytes();


        if(str2.length > str1.length){
            byte[] t = str1;
            str1 = str2;
            str2 = t;
        }



        //乘完一次 补0 的个位
        int zeros = -1;

        for (int i = str2.length - 1; i >= 0; i--) {
            int index = product.length - 1;
            int carry = 0;
            zeros ++;

            for (int j = 0; j < zeros; j++) {
                product[index--] = (byte) '0';
            }

            for (int j = str1.length - 1; j >= 0; j--) {
                int num = (str1[j] - '0') * (str2[i] - '0') + carry;
                carry = num / 10;
                num = num % 10;
                product[index--] = (byte)(num + '0');
            }

            if(carry != 0){
                product[index--] = (byte) (carry + '0');
            }


            add(product,index);

        }
        for (int i = 0; i < ans.length; i++) {
            if(ans[i] != '0'){
                return new String(ans).substring(i);
            }
        }
        return "0";
    }
    public void add(byte[] str,int index){
        int carry = 0;
        int i;
        for (i = str.length - 1; i > index ; i--) {
            int num = ans[i] - '0' + str[i] - '0' + carry;
            carry = num / 10;
            num = num % 10;
            ans[i] = (byte)(num + '0');
        }

        while (carry != 0){
            int num = ans[i] - '0' + carry;
            carry = num / 10;
            num = num % 10;
            ans[i--] = (byte) (num + '0');
        }

    }
}