package P475供暖器;

import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for(int house : houses){
            ans = Math.max(ans, findNear(house, heaters));
        }
        return ans;
    }
    private int findNear(int house, int[] heaters){
        int index = Arrays.binarySearch(heaters, house);
        if(index >= 0){
            return 0;
        }
        double newIndex = - index - 1.5;
        if(newIndex < 0){
            return heaters[0] - house;
        }
        if(newIndex > heaters.length - 1){
            return house - heaters[heaters.length - 1];
        }

        return Math.min(house - heaters[(int)(newIndex - 0.5)], heaters[(int)(newIndex + 0.5)] - house);
    }
}