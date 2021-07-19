package P45跳跃游戏II;

class Solution {
    public int jump(int[] nums) {
        boolean[] book = new boolean[nums.length + 1];

        int step = -1;
        int lastIndex = 0;

        int[] queue = new int[nums.length + 1];
        queue[0] = 0;
        int l = 0;
        int r = 1;
        while (l <= r){
            if(lastIndex == l){
                lastIndex = r;
                step ++;
            }
            int now = queue[l++];
            if(now == nums.length - 1){
                return step;
            }

            int next = Math.min(nums.length - 1,now + nums[now]);
            for (int i = now + 1; i <= next; i++) {
                if(!book[i]){
                    book[i] = true;
                    queue[r++] = i;
                }
            }
        }
        return -1;
    }
}