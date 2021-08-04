package P1928规定时间内到达终点的最小花费;

import java.util.Arrays;

class Solution {
    boolean[] book;
    int[][] map;
    int[] passingFees;
    int[] visTime;
    int[] freMoney;
    int ans;
    int maxTime;
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        this.book = new boolean[passingFees.length];
        this.map = new int[passingFees.length][passingFees.length];
        this.passingFees = passingFees;
        this.ans = Integer.MAX_VALUE;
        this.maxTime = maxTime;
        this.visTime = new int[passingFees.length];
        this.freMoney = new int[passingFees.length];
        for (int i = 0; i < visTime.length; i++) {
            visTime[i] = Integer.MAX_VALUE;
            freMoney[i] = Integer.MAX_VALUE;
        }

        for(int[] edge : edges){
            if(map[edge[0]][edge[1]] != 0){
                map[edge[0]][edge[1]] = Math.min(map[edge[0]][edge[1]],edge[2]);
                map[edge[1]][edge[0]] = Math.min(map[edge[1]][edge[0]],edge[2]);
            }else{
                map[edge[0]][edge[1]] = edge[2];
                map[edge[1]][edge[0]] = edge[2];
            }
        }
        book[0] = true;
        dfs(0,0,passingFees[0]);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public void dfs(int now,int costTime,int costMoney){
        if(now == book.length - 1){
            ans = Math.min(ans,costMoney);
            return;
        }
        for (int i = 0; i < book.length; i++) {
            if(map[now][i] != 0 && !book[i] && i != now){
                int nextCostTime = costTime + map[now][i];
                int nextCostMoney = costMoney + passingFees[i];
                if(nextCostTime <= maxTime && nextCostMoney <= ans && (nextCostMoney < freMoney[i] || nextCostTime < visTime[i])){
                    book[i] = true;
                    freMoney[i] = nextCostMoney;
                    visTime[i] = costTime;
                    dfs(i,nextCostTime,nextCostMoney);
                    book[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCost(7, new int[][]{{1, 4, 4}, {2, 3, 1}, {4, 1, 3}, {0, 2, 5}, {3, 0, 1}, {2, 1, 1}, {1, 3, 5}, {1, 2, 5}, {0, 3, 5}, {2, 4, 4}}, new int[]{7, 3, 8, 8, 1}));
    }
}
/*

一个国家有 n个城市，城市编号为0到n - 1，题目保证 所有城市都由双向道路 连接在一起。
道路由二维整数数组edges表示，其中edges[i] = [xi, yi, timei]表示城市xi和yi之间有一条双向道路，耗费时间为timei分钟。
两个城市之间可能会有多条耗费时间不同的道路，但是不会有道路两头连接着同一座城市。

每次经过一个城市时，你需要付通行费。通行费用一个长度为 n 且下标从 0 开始的整数数组 passingFees 表示，其中 passingFees[j] 是你经过城市 j 需要支付的费用。

一开始，你在城市 0 ，你想要在 maxTime 分钟以内 （包含 maxTime 分钟）到达城市 n - 1 。旅行的 费用 为你经过的所有城市 通行费之和 （包括 起点和终点城市的通行费）。

给你 maxTime，edges 和 passingFees ，请你返回完成旅行的 最小费用 ，如果无法在 maxTime 分钟以内完成旅行，请你返回 -1 。


 */

/*
24
[[27,8,37],[9,36,15],[15,8,13],[30,8,12],[21,4,30],[22,33,46],[27,29,10],[35,32,35],[22,39,34],[9,45,14],[26,21,44],[13,36,14],[3,49,20],[28,44,11],[15,30,5],[26,49,36],[8,40,3],[28,25,1],
[41,46,48],[38,24,8],[30,7,39],[14,3,36],[2,19,21],[12,39,37],[16,3,47],[11,31,22],[38,25,34],[42,6,47],[14,20,21],[33,8,35],[17,5,2],[36,19,3],[47,28,40],[37,33,35],[24,47,40],[7,15,26],
[8,0,13],[40,34,10],[25,3,19],[44,9,5],[16,6,22],[34,35,39],[24,5,2],[3,22,16],[27,24,3],[35,5,29],[5,48,49],[12,22,8],[45,15,36],[2,35,36],[24,18,14],[24,49,3],[49,20,38],[41,24,25],
[18,49,15],[24,4,23],[16,0,22],[41,46,34],[7,12,31],[9,5,13],[19,44,49],[8,25,8],[24,7,9],[4,33,38],[49,19,17],[11,31,19],[29,40,31],[30,29,10],[25,20,31],[38,28,18],[21,29,18],
[18,46,19],[43,33,43],[22,15,19],[26,44,21],[9,13,13],[0,20,9],[11,9,12],[22,39,43],[43,47,29],[12,10,34],[49,36,41],[39,48,11],[9,27,13],[9,8,30],[18,49,39],[18,33,40],
[35,22,28],[8,6,24],[14,41,10],[21,34,20],[37,6,2],[20,7,24],[11,10,29],[12,35,2],[22,41,9],[47,1,16],[29,2,38],[46,40,29],[32,47,10],[39,33,23],[24,17,3],[27,47,3],
[28,10,37],[42,48,46],[48,24,20],[48,44,16],[34,47,28],[48,34,3],[12,23,39],[13,4,44],[0,33,39],[21,3,3],[45,14,38],[36,9,18],[19,3,37],[6,2,27],[29,40,37],[37,42,44],
[10,14,10],[15,17,21],[35,12,14],[46,10,18],[41,0,47],[46,28,42],[13,19,25],[42,11,30],[27,14,47],[47,30,36],[13,43,4],[29,3,14],[36,16,40],[1,0,18],[18,6,1],[18,0,20],
[24,38,37],[25,48,12],[34,12,27],[8,42,12],[40,4,5],[33,15,13],[40,14,43],[17,23,25],[7,3,12],[41,42,32],[7,11,4],[33,23,36],[3,25,7],[20,22,29],[19,18,21],[6,34,34],[21,31,9],
[48,16,22],[14,0,7],[20,10,24],[5,6,44],[24,48,27],[4,39,1],[16,41,43],[2,27,1],[0,7,13],[6,2,30],[40,43,15],[35,39,44],[45,47,37],[29,28,40],[27,41,38],[43,48,49],[23,3,34],
[48,43,10],[7,23,17],[4,9,44],[22,41,29],[42,13,33],[40,7,24],[23,21,8],[4,3,27],[7,22,42],[12,26,3],[38,23,3],[14,8,16],[35,26,31],[40,7,9],[4,13,4],[48,47,27],[18,27,2],
[20,30,27],[7,32,32],[12,5,25],[47,41,25],[49,27,37],[9,43,4],[47,2,15],[14,47,24],[28,10,4],[36,2,11],[36,25,14],[17,5,38],[26,20,17],[25,40,5],[26,12,30],[29,19,24],
[47,16,15],[4,19,27],[8,44,1],[13,41,44],[6,20,28],[44,13,35],[11,39,25],[6,8,19],[16,30,15],[36,43,25],[43,2,9],[34,42,46],[13,18,45],[48,27,36],[16,13,9],[48,27,9],
[49,18,6],[41,5,50],[1,20,12],[27,13,40],[1,0,30],[48,28,14],[20,29,15],[14,23,27],[14,23,4],[3,48,18],[2,21,31],[18,43,31],[7,1,11],[25,23,24],[24,0,21],[2,1,38],
[20,31,27],[8,38,50],[23,16,33],[22,28,19],[48,17,8],[22,6,22],[4,3,43],[35,4,40],[32,7,8],[46,37,49],[39,24,24],[36,9,25],[39,34,22],[10,28,24],[36,8,21],[23,30,36],
[6,0,27],[35,39,47],[14,40,30],[16,24,32],[1,22,13],[0,40,32],[20,15,48],[28,16,2],[16,29,42],[24,19,1],[32,31,11],[4,29,4],[35,39,16],[46,12,38],[22,48,49],[28,12,47]
,[0,6,22],[39,44,14],[5,37,19],[43,33,33],[37,23,21],[13,8,50],[36,16,30],[9,24,30],[24,10,28],[12,42,11],[4,20,4],[6,44,31],[15,17,39],[14,30,36],[18,47,34],[18,30,28],
[16,40,50],[30,3,24],[6,4,41],[7,11,6],[10,20,20],[16,43,18],[13,27,14],[18,1,33],[24,48,45],[2,48,21],[30,18,32],[18,42,17],[42,15,36],[36,7,6],[35,31,12],[13,31,45],
[7,8,8],[39,29,12],[20,39,43],[14,42,5],[6,32,44],[11,4,21],[34,25,26],[28,29,28],[45,4,7],[12,2,5],[27,41,44],[44,34,11],[7,11,37],[31,16,13],[47,13,14],[5,34,6],
[41,11,49],[48,11,20],[33,42,2],[18,5,21],[4,19,9],[38,46,26],[26,17,13],[19,41,49],[11,38,22],[2,21,11],[13,49,14],[21,9,36],[8,14,27],[45,9,14],[1,2,1],[38,4,35]
,[1,48,39],[1,18,50],[3,5,4],[47,3,37],[6,26,31],[49,22,46],[14,19,49],[11,33,34],[17,7,25],[30,14,31],[18,14,45],[29,2,45],[14,35,49],[10,37,28],[12,15,20],[34,0,45]
,[42,7,37],[41,15,16],[47,12,26],[0,30,11],[10,1,22],[16,36,16],[24,32,10],[24,22,50],[35,4,13],[45,10,41],[17,36,23],[2,48,14],[33,11,30],[6,22,27],[42,14,35]
,[22,4,17],[25,35,26],[49,18,13],[16,25,35],[41,20,12],[2,30,29],[12,11,12],[47,3,13],[2,10,34],[13,29,15],[37,34,44],[8,33,21],[42,37,49],[48,26,31],[18,44,23],
[22,8,18],[34,37,30],[41,40,49],[17,41,11],[1,23,32],[5,1,48],[49,23,50],[40,49,32],[25,46,6],[43,30,37],[20,3,13],[5,46,49],[34,10,35],[42,48,38],[40,16,31],
[49,43,16],[24,12,16],[2,0,36],[49,29,10],[16,37,37],[22,45,44],[42,21,35],[39,33,14],[9,3,2],[42,34,19],[35,46,24],[36,30,44],[17,2,34],[4,30,29],[28,15,28],[9,8,44]
,[36,42,46],[9,14,41],[40,23,3],[41,9,23],[42,47,29],[2,22,48],[22,44,32],[15,7,46],[11,28,4],[28,7,47],[14,39,21],[2,7,6],[1,9,12],[25,16,15],[44,10,48],[46,15,3],
[7,3,32],[44,30,18],[27,10,46],[11,4,28],[49,15,15],[49,36,10],[36,15,39],[16,36,21],[11,21,29],[29,12,17],[29,31,24],[32,47,13],[3,4,17],[31,18,13],[11,33,6]
,[7,27,50],[7,3,40],[24,40,41],[47,25,42],[20,38,21],[42,25,10],[20,0,42],[31,19,6],[31,8,29],[3,19,10],[9,32,50],[15,17,40],[12,9,42],[16,28,25],[26,10,20]
,[19,0,42],[10,48,27],[47,1,33],[36,29,18],[38,36,38],[0,41,31],[17,27,23],[39,8,30],[47,37,5],[39,1,50],[39,25,21],[13,35,22],[0,22,8],[3,1,39],[11,7,3]
,[12,44,28],[33,13,27],[30,16,7],[36,45,31],[33,32,42],[33,1,15],[39,3,23],[48,6,12],[24,49,5],[13,46,22],[43,23,26],[24,15,46],[24,43,14],[0,14,31],
[42,41,6],[14,47,6],[36,39,6],[24,18,45],[10,39,1],[17,25,22],[36,23,23],[10,23,42],[40,33,41],[41,28,13],[25,1,1],[10,45,19],[40,2,42],[14,42,40],
[13,37,24],[29,38,32],[47,11,35],[24,4,45],[37,40,7],[29,45,37],[13,44,49]]
[190,843,824,838,336,528,395,301,902,169,729,254,2,463,15,649,865,840,198,789,232,516,699,157,608,893,40,87,615,294,214,66,313,103,847,326,501,1000,65,35,622,905,15,571,808,444,866,11,182,657]
 */