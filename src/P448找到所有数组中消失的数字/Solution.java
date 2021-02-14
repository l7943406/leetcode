package P448找到所有数组中消失的数字;


import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> ans = new LinkedList<>();
        boolean[] book = new boolean[nums.length + 1];
        for(int i : nums){
            book[i] = true;
        }
        for (int i = 1; i < book.length; i++) {
            if(!book[i]){
                ans.add(i);
            }
        }
        return ans;

    }
}