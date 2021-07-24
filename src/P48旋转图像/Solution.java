package P48旋转图像;

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