package p54201矩阵;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] ans;
    int[][] map;
    int[][] next = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    class Step{
        int x;
        int y;
        int step;
        public Step(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix[0] == null){
            return ans;
        }
        this.ans = new int[matrix.length][matrix[0].length];
        this.map = matrix;
        solve();
        return ans;
    }
    void solve(){
        int num = 0;
        int sum = map.length * map[0].length;
        Queue<Step> queue = new LinkedList<>();
        boolean[][] book =new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0){
                    num++;
                    queue.offer(new Step(i,j,0));
                    book[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            if(num == sum){
                return;
            }
            Step now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tx = now.x + next[i][0];
                int ty = now.y + next[i][1];
                if(tx>=0&&ty>=0&&tx<map.length&&ty<map[0].length&&!book[tx][ty]){
                    num++;
                    book[tx][ty] = true;
                    ans[tx][ty] = now.step+1;
                    queue.offer(new Step(tx,ty,now.step + 1));
                }
            }
        }

    }
}