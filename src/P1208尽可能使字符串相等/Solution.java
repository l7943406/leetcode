package P1208尽可能使字符串相等;

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0;
        int r = 0;
        int[] costs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int cost = 0;
        int ans =   Integer.MIN_VALUE;
        while( r < s.length()){
            cost += costs[r];
            if(cost > maxCost){
                cost -= costs[l];
                l++;
            }
            r++;
        }
        return s.length() - l ;
    }
}