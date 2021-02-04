package P480滑动窗口中位数;


import java.util.Arrays;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        //长度为k的数组代表滑动窗口
        int[] slid = new int[k];
        //ans数组
        double[] ans = new double[nums.length - k + 1];
        //ans下标
        int index = 0;
        //先初始化
        for (int i = 0; i < k; i++) {
            slid[i] = nums[i];
        }
        Arrays.sort(slid);

        //把k是奇偶分开对待，减少if else次数
        if(k % 2 == 0){
            //提前计算slid数组两个中间位置
            int r = k / 2;
            int l = r - 1;
            //先把前k个中位数添加进ans数组
            ans[index ++] = ((double) slid[l] + (double)slid[r]) / 2.0;
            for (int i = k; i < nums.length; i++) {
                //执行插入排序，二分查找第一个元素位置并标记删除
                sortAfterK(slid,Arrays.binarySearch(slid,nums[i - k]),nums[i]);
                ans[index ++] = ((double) slid[l] + (double)slid[r]) / 2.0;
            }
        }else {
            //slid中间位置
            int l = k / 2;
            ans[index ++] = slid[l];
            for (int i = k; i < nums.length; i++) {
                sortAfterK(slid,Arrays.binarySearch(slid,nums[i - k]),nums[i]);
                ans[index ++] = slid[l];
            }
        }
        return ans;
    }
    /**
     * 删除数组slid中deleteIndex下标代表的数据，并把num添加进有序数组slid
     * @param slid 需要排序的数组
     * @param deleteIndex  待删除的元素下表
     * @param num 待添加的数据
     * **/
    void sortAfterK(int[] slid , int deleteIndex ,int num){
        //二分查找要添加的数据在数组中的位置
        int index = Arrays.binarySearch(slid,num);
        //如果index比0小，代表num不存在于数组中
        if(index < 0){
            //如果数据不在数组中二分查找，返回值为元素在数组中的相对位置
            //举例 [1,3,5,7,9]中查找2，返回值为-2，查找4返回值为-3
            //对index取相反数并减去1.5方便判断元素处于数组中的何处
            double dIndex = - index - 1.5;
            //要添加的数据在数组中的位置比要删除的数据在数组中的位置小，让index到deleteIndex-1之间的元素后移一位覆盖待删除的元素
            if(dIndex < deleteIndex){
                index = - index - 1;
                System.arraycopy(slid, index, slid, index + 1, deleteIndex - index);
            }
            //同理，让deleteIndex到index - 1之间的元素前移一位
            else{
                index = - index - 2;
                System.arraycopy(slid, deleteIndex + 1, slid, deleteIndex, index - deleteIndex);
            }
        }else{
            //数据在数组中存在，把index处位置腾出来，原理同上
            if(index < deleteIndex){
                System.arraycopy(slid, index, slid, index + 1, deleteIndex - index);
            }else if(index > deleteIndex){
                System.arraycopy(slid, deleteIndex + 1, slid, deleteIndex, index - deleteIndex);
            }
        }
        //把num放进去
        slid[index] = num;
    }
}