package 面试题16_13平分正方形;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public double[] cutSquares(int[] square1, int[] square2) {
        //计算两正方形中心
        double square1HeartX = square1[0] + square1[2] / 2.0;
        double square1HeartY = square1[1] + square1[2] / 2.0;

        double square2HeartX = square2[0] + square2[2] / 2.0;
        double square2HeartY = square2[1] + square2[2] / 2.0;


        double k = (square2HeartY - square1HeartY) / (square2HeartX - square1HeartX);
        double b = square1HeartY - k * square1HeartX;
        boolean flagK = true;
        if(k == Double.POSITIVE_INFINITY || k == Double.NEGATIVE_INFINITY){
            k = 1;
            b = square1HeartX;
            flagK = false;
        }
        if(square1HeartX == square2HeartX && square2HeartY == square1HeartY){
            k = 1;
            b = square1HeartX;
            flagK = false;
        }

        double[][] points = new double[8][2];
        int index = 0;

        //正方形的8条直线 用于计算与平分线的交点
        int[][] lines = new int[][]{{0, square1[0]}, {0, square1[0] + square1[2]}, {1, square1[1]}, {1, square1[1] + square1[2]}
                , {0, square2[0]}, {0, square2[0] + square2[2]}, {1, square2[1]}, {1, square2[1] + square2[2]}};
        double x;
        double y;
        for(int[] line : lines){
            if(line[0] == 0){
                if(!flagK){
                    continue;
                }
                x = line[1];
                y = k * x + b;
            }else{
                if(k == 0){
                    continue;
                }
                y = line[1];
                x = (y - b) / k;
                if(!flagK){
                    x = b;
                }

            }
            points[index][0] = x;
            points[index ++][1] = y;
        }
        int n = index;
        index = 0;
        for (int i = 0; i < n; i++) {
            x = points[i][0];
            y = points[i][1];
            if((x == square1[0] || x == square1[0] + square1[2]) && y >= square1[1] && y <= square1[1] + square1[2]){
                points[index][0] = x;
                points[index++][1] = y;
            }else if((x == square2[0] || x == square2[0] + square2[2]) && y >= square2[1] && y <= square2[1] + square2[2]){
                points[index][0] = x;
                points[index++][1] = y;
            }else if((y == square1[1] || y == square1[1] + square1[2]) && x >= square1[0] && x <= square1[0] + square1[2] ){
                points[index][0] = x;
                points[index++][1] = y;
            }else if((y == square2[1] || y == square2[1] + square2[2]) && x >= square2[0] && x <= square2[0] + square2[2]){
                points[index][0] = x;
                points[index++][1] = y;
            }
        }

        Arrays.sort(points, 0, index, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1] > 0 ? 1 : -1;
            }else{
                return o1[0] - o2[0] > 0 ? 1 : -1;
            }
        });

        return new double[]{points[0][0], points[0][1], points[index - 1][0], points[index - 1][1]};
    }


}