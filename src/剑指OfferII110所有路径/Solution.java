package 剑指OfferII110所有路径;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;
    int[] road;
    int[][] graph;
    boolean[] book;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new LinkedList<>();
        road = new int[graph.length + 1];
        this.book = new boolean[graph.length];
        this.graph = graph;
        dfs(0,0);
        return ans;
    }
    private void dfs(int step,int now){
        if(now == graph.length - 1){
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < step; i++) {
                list.add(road[i]);
            }
            list.add(now);
            ans.add(list);
            return;
        }

        for(int next : graph[now]){
            if(!book[next]){
                book[next] = true;
                road[step] = now;
                dfs(step + 1,next);
                book[next] = false;
            }
        }
    }
}
/*

给定一个有n个节点的有向无环图，用二维数组graph表示，请找到所有从0到n-1的路径并输出（不要求按顺序）。

graph的第 i 个数组中的单元都表示有向图中 i号节点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ），若为空，就是没有下一个节点了。

 */