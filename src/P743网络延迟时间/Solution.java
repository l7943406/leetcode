package P743网络延迟时间;

import java.util.*;

/**
 * dfs
 * */
class Solution {
    int[] book;
    int[][] times;
    Map<Integer, List<int[]>> map;
    List<int[]> defaultList = new LinkedList<>();
    int n;

    public int networkDelayTime(int[][] times, int n, int k) {
        this.n = n;
        this.times = times;
        this.book = new int[n + 1];
        this.map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0],new LinkedList<>());
            map.get(time[0]).add(time);
        }

        Arrays.fill(this.book,-1);
        this.book[k] = 0;
        this.book[0] = 0;
        dfs(k,0,0);
        int ans = 0;
        for(int i : book){
            if(i == -1){
                ans =  -1;
                break;
            }else if(i > ans){
                ans = i;
            }
        }
        return ans;
    }
    private void dfs(int now,int time,int step){
        if(step >= n - 1){
            return;
        }
        List<int[]> list = map.getOrDefault(now,defaultList);
        for (int[] next : list) {
            if(book[next[1]] == -1 || time + next[2] < book[next[1]]){
                book[next[1]]  = time + next[2];
                dfs(next[1],time + next[2],step + 1);
            }
        }
    }
}
/*
有 n 个网络节点，标记为1到 n。

给你一个列表times，表示信号经过 有向 边的传递时间。times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。

现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。

 */