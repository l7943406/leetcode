package P455分发饼干;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
       /* Arrays.sort(g);
        Arrays.sort(s);
        */
        int ans = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            for (; j < s.length; j++) {
                if(s[j] >= g[i]){
                    ans++;
                    j++;
                    break;
                }
            }
        }
        return ans;

    }
}