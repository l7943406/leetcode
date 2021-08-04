package P1854人口最多的年份;

class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] peopleLogs = new int[102];
        for(int[] log : logs){
            peopleLogs[log[0] - 1949] ++;
            peopleLogs[log[1] - 1949] --;
        }
        int ans = logs[0][0];
        int max = 0;
        for (int i = 1; i < peopleLogs.length; i++) {
            peopleLogs[i] += peopleLogs[i - 1];
            if(peopleLogs[i] > max){
                max = peopleLogs[i];
                ans = i + 1949;
            }
        }
        return ans;
    }
}
/*
给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。

年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。

返回 人口最多 且 最早 的年份。
 */