package P771宝石与石头;

class Solution {
    public int numJewelsInStones(String J, String S) {
        byte[] book = new byte[200];
        for (int i = 0; i < S.length(); i++) {
            book[S.charAt(i)]++;
        }
        int ans = 0;
        for (int i = 0; i < J.length(); i++) {
            ans += book[J.charAt(i)];
        }
        return ans;
    }
}