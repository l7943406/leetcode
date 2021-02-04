package P67二进制求和;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public String addBinary(String a, String b) {
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.length()<b.length()) {
            return addBinary(b,a);
        }
        StringBuilder s1 = new StringBuilder(a);
        StringBuilder s2 = new StringBuilder(b);





        StringBuilder ans = new StringBuilder();
        s1 = s1.reverse();
        s2 = s2.reverse();
        int n = s1.length()-s2.length();
        for (int i = 0;i<n;i++){
            s2.append('0');
        }


        int t=0;
        for(int i=0;i<s1.length();i++){
           t=s1.charAt(i)-'0'+s2.charAt(i)-'0'+t;
           if(t>1){
               t-=2;
               ans.append(t);
           }else{
               ans.append(t);
               t=0;
           }
        }
        if(t!=0){
            ans.append('1');
        }
        return String.valueOf(ans.reverse());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11","1"));
    }
}
