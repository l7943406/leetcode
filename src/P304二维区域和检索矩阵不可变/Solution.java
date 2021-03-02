package P304二维区域和检索矩阵不可变;

import P141环形链表.Solution;

class NumMatrix {
    int[][] arr;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        arr = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[i + 1][j + 1] = matrix[i][j];
                arr[i + 1][j + 1] += arr[i][j + 1] + arr[i + 1][j] - arr[i][j];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return arr[row2 + 1][col2 + 1] - arr[row2 + 1][col1] - arr[row1][col2 + 1] + arr[row1][col1];
    }
}