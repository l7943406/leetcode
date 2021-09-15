package P600不含连续1的非负整数;

class Solution {
    int n;
    int ans;
    public int findIntegers(int n) {
        this.n = n;
        this.ans = 1;
        dfs(1);
        return this.ans;
    }
    private void dfs(int num){
        if(num > n){
            return;
        }
        ans ++;
        int last = num & 1;
        dfs(num << 1);
        if(last == 0){
            dfs((num << 1) + 1);
        }
    }
}