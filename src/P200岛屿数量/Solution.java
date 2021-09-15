package P200岛屿数量;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] nextS = {{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    bfs(grid, i, j, (char) ans--);
                }
            }
        }
        return -ans;
    }
    private void bfs(char[][] grid, int x, int y, char flag){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int[] next : nextS) {
                int nextX = now[0] + next[0];
                int nextY = now[1] + next[1];
                if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[nextX].length) {
                    if (grid[nextX][nextY] == '1') {
                        grid[nextX][nextY] = flag;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}