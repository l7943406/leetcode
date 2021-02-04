package P861反转矩阵后的得分;

class Solution {
    public int matrixScore(int[][] A) {
        int zero = 0;
        int one = 0;
        for (int[] ints : A) {
            if (ints[0] == 1) {
                one++;
            } else {
                zero++;
            }
            if (zero > one) {
                reverseColumn(A, 0);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if(A[i][0] == 0){
                reverseRow(A,i);
            }
        }
        for (int i = 1; i < A[0].length; i++) {
            zero = 0;
            one = 0;
            for (int[] ints : A) {
                if (ints[i] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            if(zero > one){
                reverseColumn(A,i);
            }
        }
        int ans = 0;
        for (int[] ints : A) {
            for (int j = 0; j < ints.length; j++) {
                // System.out.print(A[i][j]);
                ans = (int) (ans + ints[j] * Math.pow(2, ints.length - j - 1));
            }
            //System.out.println();
        }
        return ans;
    }
    //翻转行
    public void reverseRow(int[][] A,int t){
        for (int i = 0; i < A[0].length; i++) {
            A[t][i] ^= 1;
        }
    }
    //翻转列
    public void reverseColumn(int[][] A,int t){
        for (int i = 0; i < A.length; i++) {
            A[i][t] ^= 1;
        }
    }
/*
    public static void main(String[] args) {
        int[][] A ={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        new Solution().matrixScore(A);
    }*/
}