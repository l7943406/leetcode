package P1556千位分割数;

import java.util.Collections;

class Solution {
    public String thousandSeparator(int n) {
        if(n==0){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        int t=0;
        while(n!=0){
            if(t!=0&&t%3 == 0){
                ans.append('.');
            }
            ans.append(n%10);
            t++;
            n/=10;
        }
        return String.valueOf(ans.reverse());
    }
}