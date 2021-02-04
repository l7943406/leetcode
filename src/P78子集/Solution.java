package P78子集;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;
    int length;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {

        ans = new ArrayList<>();
        length = nums.length;
        this.nums = nums;
        int n = binaryNum(length);


        for(int i=0;i<n;i++){
            String s = binary(i);
            add(s);
        }



        return ans;
    }
    void add(String s){
        List<Integer> list = new ArrayList<>();
        for(int i=0 ;i<length ;i++){
            if(s.charAt(i)=='1'){
                list.add(nums[i]);
            }
        }
        ans.add(list);

    }
    String binary (int n){
        StringBuilder s = new StringBuilder();
        do {
            s.append(n%2);
        }while((n/=2)!=0);

        int length1 = s.length();
        for(int i=0;i<length-length1;i++){
            s.append(0);
        }
        s.reverse();
        return String.valueOf(s);
    }
    int binaryNum(int n){
        int ans=0;
        for(int i=0;i<n;i++){
            ans += Math.pow(2,i);
        }
        return ans+1;
    }

    public static void main(String[] args) {
        new Solution().subsets(new int[]{1,2,3,4,5});
    }
}