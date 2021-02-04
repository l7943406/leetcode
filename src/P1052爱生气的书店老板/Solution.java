package P1052爱生气的书店老板;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < X; i++) {
            max += customers[i] * grumpy[i];
            ans += customers[i] * (grumpy[i]^1);
        }
        int t = max;
        for (int i = X; i < customers.length; i++) {
            ans += customers[i] * (grumpy[i]^1);
            t = t - (grumpy[i - X] * customers[i - X]) + (grumpy[i] * customers[i]);
            max = Math.max(max,t);
        }
        return ans+max;
    }
    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < X; i++) {
            if(grumpy[i] == 0){
                ans += customers[i];
                customers[i] = 0;
            }
            max += customers[i];
        }
        int t = max;
        for (int i = X; i < customers.length; i++) {
            if(grumpy[i] == 0){
                ans += customers[i];
                customers[i] = 0;
            }
            t = t - (customers[i - X]) + (customers[i]);
            max = Math.max(max,t);
        }
        return ans+max;
    }
}