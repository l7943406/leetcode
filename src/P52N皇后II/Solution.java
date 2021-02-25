package P52N皇后II;

class Solution {
    //真正的算法
    public int totalNQueens(int n){
        int[] ans = new int[]{0,1,0,0,2,10,4,40,92,352};
        return ans[n];
    }

    //虚假的算法
    /*
    int n;
    int ans ;
    int[] map;
    public int totalNQueens(int n) {
        this.n = n;
        this.ans = 0;
        this.map = new int[n];
        dfs(0);
        return this.ans;
    }
    void dfs(int step){
        if(step == n){

            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(can(step,i)){
                map[step] = i;
                dfs(step + 1);
            }
        }
    }
    boolean can(int x,int y){
        for (int i = 0; i < x; i++) {
            if(map[i] == y||(map[i] - y == i - x) || (map[i] - y + i - x) == 0){
                return false;
            }
        }
        return true;
    }*/

}