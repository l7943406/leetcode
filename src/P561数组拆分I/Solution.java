package P561数组拆分I;


class Solution{
    int[] nums;
    int[] book;
    int add = 10000;
    public int arrayPairSum(int[] nums) {
        this.nums = nums;
        sort();
        int ans = 0;
        boolean is = true;
        for (int i = 0; i < 20001; i++) {
            for (int j = 0; j < book[i]; j++) {
                if(is){
                    ans += i;
                }
                is = !is;
            }
        }
        return ans;
    }

    private void sort(){
        book = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            book[nums[i] + add] ++;
        }
    }
}