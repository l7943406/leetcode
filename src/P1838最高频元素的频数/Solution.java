package P1838最高频元素的频数;


class Solution {
    public int maxFrequency(int[] nums, int k) {
        // 取最大元素作为桶大小
        int max = 0;
        for(int i : nums){
            max = Math.max(max,i);
        }
        int[] map = new int[max + 1];

        //桶排
        for(int i : nums){
            map[i] ++;
        }

        //维护 滑动窗口区间的元素距离当前元素的距离值
        int t = 0;
        //ans
        int ans = 0;

        //队列头尾 因为nums排过序放桶里了 直接把nums当队列
        int l = 0;
        int r = 0;
        for (int i = 0; i < map.length; i++) {
            // 每次t加上当前队列长度 因为后移一位后 滑动窗口每一个元素都距离当前元素远离了1
            t += r - l;
            //当当前元素存在时才有可能是最大值 再开始维护
            if(map[i] > 0){
                //维护滑动窗口 贪心去掉远距离元素
                while (t > k){
                    t -= i - nums[l++];
                }
                //取ans 为 ans 和 当前元素数量 + 队列长度最大值
                ans = Math.max(ans,map[i] + r - l);
                //加进队列
                for (int j = 0; j < map[i]; j++) {
                    nums[r ++] = i;
                }
            }
        }
        return ans;
    }
}