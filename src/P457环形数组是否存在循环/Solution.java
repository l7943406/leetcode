package P457环形数组是否存在循环;

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int max = 1001;
        int min = -1001;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] > -1001 && nums[i] < 1001){
                if(nums[i] < 0){
                    int id = min - 1;
                    int index = i;
                    while (nums[index] < 0 && nums[index] > -1001){
                        index = (index + nums[index] + nums.length) % nums.length;
                    }
                    if(nums[index] == id){
                        return true;
                    }
                }else{
                    int id = max + 1;
                    int index = i;
                    while (nums[index] > 0 && nums[index] < 1001){
                        index = (index + nums[index]) % nums.length;
                    }
                    if(nums[index] == id){
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
/*

存在一个不含 0 的 环形 数组nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：

如果 nums[i] 是正数，向前 移动 nums[i] 步
如果nums[i] 是负数，向后 移动 nums[i] 步
因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。

数组中的 循环 由长度为 k 的下标序列 seq ：

遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
所有 nums[seq[j]] 应当不是 全正 就是 全负
k > 1
如果 nums 中存在循环，返回 true ；否则，返回 false 。

 */