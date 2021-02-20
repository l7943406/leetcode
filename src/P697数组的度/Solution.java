package P697数组的度;

class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] book = new int[50000];
        int[] start = new int[50000];
        int[] end = new int[50000];
        int max = 0;
        int min = 50001;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if(book[t] == 0){
                start[t] = i;
            }
            end[t] = i;
            book[t] ++;
            if(book[t] > max){
                max = book[t];
            }
        }
        for (int i = 0; i < book.length; i++) {
            if(book[i] == max){
                int t = end[i] - start[i] + 1;
                if(t < min){
                    min = t;
                }
            }
        }

        return min;
    }
}