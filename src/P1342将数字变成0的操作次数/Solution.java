package P1342将数字变成0的操作次数;

class Solution {
    public int numberOfSteps (int num) {
        int ans =0;
        while(num!=0){
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            ans++;
        }
        return ans;
    }
}