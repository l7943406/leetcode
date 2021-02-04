package P312戳气球;

import java.util.LinkedList;

class Solution {
    LinkedList<Integer> list;
    public int maxCoins(int[] nums) {
        int ans = 0;
        list = new LinkedList<>();
        list.add(1);
        for (int num : nums) {
            list.add(num);
        }
        list.add(1);
        while(list.size() > 2){
            
        }
        return ans;
    }
    public int minIndex(){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 1; i < list.size() - 1; i++) {
            int num = list.get(i);
            if(num < min){
                min = num;
                index = i;
            }
        }
        for (int i = 1; i < list.size() - 1; i++) {
            int num = list.get(i);
            if(num < min){
                min = num;
                index = i;
            }
        }
        return index;
    }
}