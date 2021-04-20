package p461汉明距离;


import java.math.BigDecimal;

class Solution {/*
    public int hammingDistance(int x, int y) {
        String X = Integer.toBinaryString(x);
        String Y = Integer.toBinaryString(y);
        int ans = 0;
        if(X.length() > Y.length()){
            for (int i = 0; i < X.length() - Y.length(); i++) {
                if(X.charAt(i) == '1'){
                    ans++;
                }
            }
            for (int i = X.length() - Y.length(); i < X.length(); i++) {
                if(X.charAt(i) != Y.charAt(i - X.length() + Y.length())){
                    ans++;
                }
            }
        }else{
            for (int i = 0; i < Y.length() - X.length(); i++) {
                if(Y.charAt(i) == '1'){
                    ans++;
                }
            }
            for (int i = Y.length() - X.length(); i < Y.length(); i++) {
                if(Y.charAt(i) != X.charAt(i - Y.length() + X.length())){
                    ans++;
                }
            }
        }

        return ans;
    }*/
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }



}