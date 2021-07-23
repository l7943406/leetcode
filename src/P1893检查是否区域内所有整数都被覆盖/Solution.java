package P1893检查是否区域内所有整数都被覆盖;

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] map = new int[52];
        for(int[] range : ranges){
            map[range[0]]++;
            map[range[1] + 1]--;
        }
        int t = 0;
        for (int i = 0; i < map.length; i++) {
            t += map[i];
            if(i >= left && i <= right && t < 1){
                return false;
            }
        }
        return true;
    }
}
/*
 1 2 3 4 5 6
 1
*/
