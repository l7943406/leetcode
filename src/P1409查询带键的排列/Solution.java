package P1409查询带键的排列;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] num = new int[m];
        int[] index = new int[m + 1];
        int[] ans = new int[queries.length];
        for (int i = 0; i < m; i++) {
            num[i] = i + 1;
            index[i + 1] = i;
        }
        for (int i = 0 ;i < queries.length ;i++ ) {
            int n = index[queries[i]];
            ans[i] = n;
            int t = num[n];


            for (int j = n; j > 0; j --) {
                num[j] = num[j - 1];
                index[num[j]] = j;
            }

            index[t] = 0;
            num[0] = t;
        }
        return ans;
    }
}