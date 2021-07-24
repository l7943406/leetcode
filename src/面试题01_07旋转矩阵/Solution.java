package 面试题01_07旋转矩阵;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int[] t = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = t;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }


    }
}

/*
[ 5, 1, 9,11],
[ 2, 4, 8,10],
[13, 3, 6, 7],
[15,14,12,16]

|

[15,14,12,16]
[13, 3, 6, 7],
[ 2, 4, 8,10],
[ 5, 1, 9,11],

* */