package P363矩形区域不超过K的最大数值和;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i!=0){
                    matrix[i][j] += matrix[i - 1][j];
                }
                if(j!=0){
                    matrix[i][j] += matrix[i][j - 1];
                }
                if(i!=0 && j!=0){
                    matrix[i][j] -= matrix[i-1][j-1];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int l = i; l < matrix.length; l++) {
                    for (int m = j; m < matrix[l].length; m++) {
                        int num = matrix[l][m] - (i > 0 ? matrix[i-1][m] : 0) - (j > 0 ? matrix[l][j - 1] : 0) + (i > 0 && j > 0 ? matrix[i - 1][j - 1] : 0);
                        if(num > k){
                            continue;
                        }
                        max = Math.max(max,num);
                    }
                }
            }
        }

        return max;
    }
}