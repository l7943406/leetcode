package P989数组形式的整数加法;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        StringBuilder num = new StringBuilder();
        for(int i = 0;i < A.length ; i++){
            num.append(A[i]);
        }
        BigInteger big = new BigInteger(String.valueOf(num));
        big = big.add(new BigInteger(String.valueOf(K)));
        String s = big.toString();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            ans.add(s.charAt(i) - '0');
        }
        return ans;

    }


}