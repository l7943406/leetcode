package P778水位上升的泳池中游泳;


import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int[][] next = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] book = new boolean[grid.length][grid[0].length];
        PriorityQueue<node> queue = new PriorityQueue<>(new myCmp());
        queue.offer(new node(0,0,grid[0][0]));
        book[0][0] = true;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            node now = queue.poll();
            max = Math.max(max,now.grid);
            if(now.x == grid.length - 1 && now.y == grid[0].length - 1){
                return max;
            }
            int tx,ty;
            for (int i = 0; i < 4; i++) {
                tx = now.x + next[i][0];
                ty = now.y + next[i][1];
                if(tx >= 0&& tx < grid.length && ty >=0 && ty< grid[0].length && !book[tx][ty]){
                    book[tx][ty] = true;
                    queue.offer(new node(tx,ty,grid[tx][ty]));
                }
            }
        }
        return max;

    }
    class node{
        int x;
        int y;
        int grid;
        public node(int x, int y, int grid) {
            this.x = x;
            this.y = y;
            this.grid = grid;
        }
    }
    class myCmp implements Comparator<node>{
        @Override
        public int compare(node o1, node o2) {
            return o1.grid - o2.grid;
        }
    }
}
