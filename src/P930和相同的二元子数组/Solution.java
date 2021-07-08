package P930和相同的二元子数组;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        if(goal == 0){
            int num = 0;
            for(int i : nums){
                if(i == 1){
                    ans += (1 + num) * (num / 2) + (num % 2 == 0 ? 0 : num / 2 + 1);
                    num = 0;
                }else{
                    num ++;
                }
            }
            ans +=  (1 + num) * (num / 2) + (num % 2 == 0 ? 0 : num / 2 + 1);
        }else{
            int sum = 0;

            int left = 0;
            int right = 0;

            int leftZeros = 0;
            int rightZeros = 0;


            while(right < nums.length){
                if(sum == 0 && nums[right] == 1){
                    left = right;
                }
                sum += nums[right];

                if(sum == goal){
                    break;
                }
                right ++;
            }

            while(right < nums.length){
                leftZeros = 1;
                rightZeros = 1;
                for(int i = left - 1; i >= 0; i--){
                    if(nums[i] == 1){
                        break;
                    }
                    leftZeros ++;
                }

                for(int i = right + 1; i < nums.length; i++){
                    if(nums[i] == 1){
                        break;
                    }
                    rightZeros ++;
                }
                ans += leftZeros * rightZeros;

                left ++;
                for(; left < nums.length; left++){
                    if(nums[left] == 1){
                        break;
                    }
                }

                right++;
                for(; right < nums.length; right++){
                    if(nums[right] == 1){
                        break;
                    }
                }

            }
        }


        return ans;
    }
}