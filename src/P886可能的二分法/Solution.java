package P886可能的二分法;

import java.util.LinkedList;

class Solution {
    LinkedList<Integer>[] map;
    boolean[] book;
    boolean ans = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        book = new boolean[n + 1];
        map = new LinkedList[n + 1];
        for(int[] dislike : dislikes){
            if(map[dislike[0]] == null){
                map[dislike[0]] = new LinkedList();
            }
            if(map[dislike[1]] == null){
                map[dislike[1]] = new LinkedList();
            }
            map[dislike[0]].add(dislike[1]);
            map[dislike[1]].add(dislike[0]);
        }
        for (int i = 0; i < map.length; i++) {
            if(map[i] != null && !book[i]){
                book[i] = true;
                dfs(i, i);
            }
        }
        return ans;
    }
    private void dfs(int now,int last){
        if(!ans){
            return;
        }
        for (int next : map[now]) {
            if(next == last){
                continue;
            }
            if(book[next]){
                ans = false;
                return;
            }
            book[next] = true;
            dfs(next, now);
        }
    }
}
/*
10
[[4,7],[4,8],[5,6],[1,6],[3,7],[2,5],[5,8],[1,2],[4,9],[6,10],[8,10],[3,6],[2,10],[9,10],[3,9],[2,3],[1,9],[4,6],[5,7],[3,8],[1,8],[1,7],[2,4]]
 */