package P260只出现一次的数字III;

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        int count = 0;
        while (xor != 0){
            if((xor & 1) == 1){
                break;
            }
            xor >>>= 1;
            count++;
        }
        int xor1 = 0;
        int xor2 = 0;

        for(int num : nums){
            if(((num >>> count) & 1) == 1){
                xor1 ^= num;
            }else{
                xor2 ^= num;
            }
        }

        return new int[]{xor1, xor2};

    }
}
