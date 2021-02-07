package P665非递减数列;

class Solution {
    public boolean checkPossibility(int[] nums) {
        //计数，代表改变数字的次数
        int num = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //如果nums[i]大于nums[i+1] 此时需要改变两个数中的一个
            if(nums[i] > nums[i+1]){
                //判断i-1是否还在数组范围内
                if(i - 1 >=0){
                    //例:[1,1,5,4,999],这时把5变成4，这里是贪心的思想，这样改能让nums[i+1]最小
                    if(nums[i+1] >= nums[i-1]){
                        nums[i] = nums[i+1];
                    }
                    //没有办法更改nums[i]，只能让nums[i+1]改变
                    else{
                        nums[i+1] = nums[i];
                    }
                }else{
                    //如果不在就把nums[0]变为nums[1];
                    //例:[4,2,3,...,],此时直接把4改成2就行
                    nums[0] = nums[i + 1];
                }
                num++;
            }
        }
        return num <= 1;
    }
}