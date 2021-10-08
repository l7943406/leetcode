package P797所有可能的路径;

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;
    int[][] graph;
    int[] stack;
    int top;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.ans = new LinkedList<>();
        this.graph = graph;
        this.stack = new int[graph.length];
        this.top = 0;
        stack[top++] = 0;
        dfs(0);
        top --;
        return ans;
    }

    private void dfs(int index){
        if(index == stack.length - 1){
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < top; i++) {
                list.add(stack[i]);
            }
            ans.add(list);
            return;
        }
        for(int next : graph[index]){
            stack[top++] = next;
            dfs(next);
            top --;
        }

    }
}
/*
给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n - 1 的路径并输出（不要求按特定顺序）

二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。

译者注：有向图是有方向的，即规定了 a → b 你就不能从 b → a 。
 */