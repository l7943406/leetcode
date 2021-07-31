package P1945字符串转化后的各位数字之和;

class Solution {
    public int getLucky(String s, int k) {
        StringBuilder numS = new StringBuilder();
        for(byte c : s.getBytes()){
            numS.append(c - 'a' + 1);
        }
        int ans = 0;
        for (byte c : numS.toString().getBytes()) {
            ans += c - '0';
        }
        for (int i = 0; i < k - 1; i++) {
            int t = ans;
            ans = 0;
            while (t != 0){
                ans += t%10;
                t/=10;
            }
        }
        return ans;
    }
}