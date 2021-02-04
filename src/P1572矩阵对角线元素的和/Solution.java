package P1572矩阵对角线元素的和;

class Solution {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            ans += mat[i][i] + mat[mat.length - i - 1][mat.length - i - 1];
        }
        return mat.length%2 == 0 ?  ans - mat[mat.length/2][mat.length/2] :ans ;
    }

}