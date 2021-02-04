package P807保持城市天际线;

import java.awt.*;
import java.util.stream.IntStream;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        byte[] maxX = new byte[grid[0].length];
        byte[] maxY = new byte[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxX[i] = (byte) Math.max(maxX[i],grid[i][j]);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                maxY[i] = (byte) Math.max(maxY[i], grid[j][i]);
            }
        }


        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(maxX[i] == grid[i][j] || maxY[j] == grid[i][j]){

                }else{
                    ans += Math.min(maxX[i],maxY[j]) - grid[i][j];
                }
            }
        }

        return ans;
    }
}