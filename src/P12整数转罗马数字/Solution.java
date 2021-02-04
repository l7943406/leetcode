package P12整数转罗马数字;

import javax.print.DocFlavor;
import java.net.InetSocketAddress;

class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        while(num!=0){
            if(num>=1000){
                num-=1000;
                ans.append("M");
            }else if(num>=900){
                num-=900;
                ans.append("MC");
            }else if(num>=500){
                num-=500;
                ans.append("D");

            }else if(num>=400){
                num-=400;
                ans.append("DC");

            }else if(num>=100){
                num-=100;

                ans.append("C");

            }else if(num>=90){
                num-=90;

                ans.append("CX");

            }else if(num>=50){
                num-=50;

                ans.append("L");

            }else if(num>=40){
                num-=40;

                ans.append("LX");

            }else if(num>=10){
                num-=10;

                ans.append("X");

            }else if(num>=9){
                num-=9;

                ans.append("XI");

            }else if(num>5){
                num-=5;

                ans.append("V");

            }else if(num>4){
                num-=4;

                ans.append("VI");
            }else if(num>0){
                num-=1;

                ans.append("I");
            }
        }
        return String.valueOf(ans.reverse());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3999));
    }
}