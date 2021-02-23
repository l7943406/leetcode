package P5686移动所有球到每个盒子所需的最小操作数;

class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        int all = 0;
        int left = 0;
        if(boxes.charAt(0) == '1'){
            left ++;
            all++;
        }
        for (int i = 1; i < boxes.length(); i++) {
            if(boxes.charAt(i) == '1'){
                all++;
                ans[i] += Math.abs(i);
            }
        }
        for (int i = 1; i < boxes.length(); i++) {
            if(boxes.charAt(i) == '1'){
                ans[i] = ans[i - 1] + left - (all - left - 1) - 1;
                left ++;
            }else{
                ans[i] = ans[i - 1] + left - (all - left);
            }
        }
        return ans;
    }
}