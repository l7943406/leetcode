package P1319连通网络的操作次数;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    LinkedList<Integer>[] map;
    boolean[] book;
    int ans;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }

        map = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new LinkedList<>();
        }
        for (int[] connection : connections) {
            map[connection[0]].add(connection[1]);
            map[connection[1]].add(connection[0]);
        }
        this.book = new boolean[n];
        this.ans = 0;

        bfs(0);
        for (int i = 0; i < book.length; i++) {
            if(!book[i]){
                ans ++ ;
                bfs(i);
            }
        }

        return ans;
    }
    void bfs(int index){
        book[index] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int next : map[now]) {
                if (!book[next]) {
                    book[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}