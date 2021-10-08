package P2007从双倍数组中还原原数组;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed == null || (changed.length & 1) == 1){
            return new int[0];
        }
        int[] map = new int[100001];
        for(int num : changed){
            map[num] ++;
        }

        int top = 0;
        int[] ans = new int[changed.length / 2];
        if((map[0] & 1) == 1){
            return new int[0];
        }
        for (int i = 0; i < map[0] >> 1; i++) {
            ans[top ++] = 0;
        }
        for (int i = 1; i < map.length; i++) {
            if(map[i] > 0){
                if((i << 1) <= 100000 && map[i << 1] >= map[i]){
                    for (int j = 0; j < map[i]; j++) {
                        ans[top ++] = i;
                    }
                    map[i << 1] -= map[i];
                    map[i] = 0;
                }else{
                    return new int[0];
                }
            }
        }
        return ans;

    }
}