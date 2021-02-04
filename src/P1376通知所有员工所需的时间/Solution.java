package P1376通知所有员工所需的时间;

import java.util.Arrays;

class Solution {
    int ans;
    int n;
    int headID;
    int[] manager;
    int[] informTime;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.ans = 0;
        this.n = n;
        this.headID = headID;
        this.manager = manager;
        this.informTime = informTime;
        boolean[] isLeaf = new boolean[n];
        Arrays.fill(isLeaf,true);
        for (int i = 0; i < n; i++) {
            if(manager[i] == -1){
                isLeaf[i] = false;
            }else {
                isLeaf[manager[i]] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            if(isLeaf[i]){
                solve(i,0);
            }
        }



        return ans;
    }
    void solve(int now , int time){
        if(now == headID){
            time += informTime[headID];
            ans = Math.max(time,ans);
            return;
        }
        solve(manager[now],time + informTime[now]);
    }

    public static void main(String[] args) {
        //n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
        int n = 7;
        int headID = 6;
        int[] manager = {1,2,3,4,5,6,-1};
        int[] informTime = {0,6,5,4,3,2,1};
        new Solution().numOfMinutes(n,headID,manager,informTime);
    }
}