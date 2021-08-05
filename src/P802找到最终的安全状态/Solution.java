package P802找到最终的安全状态;

import java.util.*;

class Solution {
    int[][] graph;
    /**
    * 0 未访问
    * 1 以访问
    * 2 安全
    * 3 环
    * */
    int[] flag;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        this.flag = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(flag[i] == 0){
                flag[i] = 1;
                dfs(i);
            }
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if(flag[i] == 2){
                ans.add(i);
            }
        }
        return ans;
    }
    private void dfs(int step){
        if(graph[step].length == 0){
            flag[step] = 2;
            return;
        }
        for (int next : graph[step]) {
            if(flag[next] == 0){
                flag[next] = 1;
                dfs(next);
            }
            if(flag[next] == 3 || flag[next] == 1){
                flag[step] = 3;
                return;
            }
        }
        if(flag[step] != 3){
            flag[step] = 2;
        }
    }
}
/*

在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。

对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。

返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。

该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是graph的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。

 */