package P179最大数;

import java.util.Arrays;
import java.util.Comparator;

    //傻傻的比较时间复杂度O(nlogn)
class Solution {
    public String largestNumber(int[] nums) {
        String[] sNum = new String[nums.length];
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            StringBuilder s = new StringBuilder();
            int t = 0;
            t++;
            s.append(nums[i] % 10);
            nums[i] /= 10;
            while (nums[i] != 0){
                t++;
                s.append(nums[i] % 10);
                nums[i] /= 10;
            }
            n = Math.max(n,t);
            s.reverse();
            sNum[i] = s.toString();
        }
        Arrays.sort(sNum,new MyCmp());
        StringBuilder ans = new StringBuilder();
        boolean allZero = true;
        for (String s : sNum) {
            if(allZero){
                if(s.length() != 1 || s.charAt(0) != '0'){
                    allZero = false;
                }
            }
            ans.append(s);
        }
        if(allZero){
            return "0";
        }
        return ans.toString();
    }
    class MyCmp implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int length = Math.max(s1.length(),s2.length());
            for (int i = 0; i < length; i++) {
                char a = s1.charAt(i % s1.length());
                char b = s2.charAt(i % s2.length());
                if(a != b){
                    return b - a;
                }
            }

            if(s1.length() < s2.length()){
                if(s2.length() % s1.length() == 0){
                    return 0;
                }
                return compare(s1,s2.substring(((s2.length() / s1.length()) * s1.length())));
            }else if(s1.length() > s2.length()){
                if(s1.length() % s2.length() == 0){
                    return 0;
                }
                return compare(s1.substring((s1.length() / s2.length()) * s2.length()),s2);
            }else{
                return 0;
            }
        }
    }

}