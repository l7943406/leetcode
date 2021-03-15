package P54螺旋矩阵;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (; x < matrix[0].length; x++) {
                if(matrix[y][x] == -101){
                    break;
                }else{
                    ans.add(matrix[y][x]);
                    matrix[y][x] = -101;
                }
            }
            x--;
            y++;
            for (; y < matrix.length; y++) {
                if(matrix[y][x] == -101){
                    break;
                }else{
                    ans.add(matrix[y][x]);
                    matrix[y][x] = -101;
                }
            }
            x--;
            y--;
            for (; x >= 0; x--) {
                if(matrix[y][x] == -101){
                    break;
                }else{
                    ans.add(matrix[y][x]);
                    matrix[y][x] = -101;
                }
            }
            x++;
            y--;
            for (; y >= 0; y--) {
                if(matrix[y][x] == -101){
                    break;
                }else{
                    ans.add(matrix[y][x]);
                    matrix[y][x] = -101;
                }
            }
            y++;
            x++;
            if(ans.size() == matrix[0].length * matrix.length){
                break;
            }
        }
        return ans;
    }
}