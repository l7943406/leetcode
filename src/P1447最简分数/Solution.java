package P1447最简分数;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private int gcd(int a,int b){
        return b == 0 ?  a : gcd(b, a % b) ;
    }

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = n; i >= 2; i--) {
            for (int j = 1; j < i; j++) {
                if(gcd(i,j) == 1){
                    ans.add(j + "/" + i);
                }
            }
        }

        return ans;
    }
}