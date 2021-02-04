package P1030距离顺序排列矩阵单元格;

import java.util.Arrays;
import java.util.Comparator;


/**
 *
 * **/
class Solution{
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        //返回数组
        int [][] ans = new int[R*C][2];
        //栈下标
        int now = 0;
        //环数
        int n = ( Math.max(R,C) - 1) / 2;
        //圈数
        int ring = 0;
        //行
        int row;
        //列
        int column;
        for(int i = 0; i < n ; i++){

        }
        return ans;
    }
}

/*
思路一：老老实实排序
class Solution {
    static int ro;
    static int c0;
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Solution.ro = r0;
        Solution.c0 = c0;
        int [][] ans = new int[R*C][2];
        int length = 0;
        for(int i = 0; i < R; i++){
            for (int j = 0; j < C; j++) {
                ans[length][0] = i;
                ans[length][1] = j;
                length++;
            }
        }
        Arrays.sort(ans,new MyCmp());
        return ans;
    }
}
class MyCmp implements Comparator<int []> {
    @Override
    public int compare(int[] o1, int[] o2) {
        int O1 = Math.abs(o1[0] - Solution.ro) + Math.abs(o1[1] - Solution.c0);
        int O2 = Math.abs(o2[0] - Solution.ro) + Math.abs(o2[1] - Solution.c0);
        return O1 - O2;
    }
}*/