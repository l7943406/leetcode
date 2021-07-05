package P451根据字符出现频率排序;


class Solution {
    public String frequencySort(String s) {
        byte[] ans = new byte[s.length()];
        int t = 0;

        int[] map = new int[127];
        for(int c : s.getBytes()){
            map[c] ++;
        }
        for(int i = 0; i < 127; i++){
            int index = 0;
            for(int j = 0; j < 127; j++){
                if(map[j] > map[index]){
                    index = j;
                }
            }

            for(int j = 0; j < map[index]; j++){
                ans[t++] = (byte)index;
            }
            map[index] = 0;
        }
        return new String(ans);
    }
}