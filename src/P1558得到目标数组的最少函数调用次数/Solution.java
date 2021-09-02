package P1558得到目标数组的最少函数调用次数;

class Solution {
    int count;
    int num;
    public int minOperations(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for(int num : nums){
            if(num > 0){
                sum1 ++;
                getCount(num);
                sum2 = Math.max(sum2, count);
                sum3 += num - this.num;
            }
        }
        return sum1 + sum2 + sum3;
    }
    private void getCount(int num){
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int n = (int) Math.pow(2,i);
            if(n > num){
                return;
            }

            this.num = n;
            this.count = i;

        }
    }

}