package P766托普利茨矩阵;

class Solution {
    /*方法1：模拟*/
    public boolean isToeplitzMatrix1(int[][] matrix) {
        for (int i = matrix.length - 1; i > 0 ; i--) {
            int now = matrix[i][0];
            for (int x = i,y = 0;  x < matrix.length && y < matrix[0].length ; x++,y++) {
                if(matrix[x][y] != now){
                    return false;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int now = matrix[0][i];
            for (int x = 0,y = i;  x < matrix.length && y < matrix[0].length ; x++,y++) {
                if(matrix[x][y] != now){
                    return false;
                }
            }
        }
        return true;
    }
    /*方法二，直接遍历*/
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}