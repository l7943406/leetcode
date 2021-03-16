package P59螺旋矩阵;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int num = 1;
        int x = 0;
        int y = 0;
        while (true){
            for (; x < n; x++){
                if(ans[y][x] != 0){
                    break;
                }else{
                    ans[y][x] = num++;
                }

            }
            x--;
            y++;
            for (; y < n; y++){
                if(ans[y][x] != 0){
                    break;
                }else{
                    ans[y][x] = num++;
                }

            }
            x--;
            y--;
            for (; x >= 0; x--){
                if(ans[y][x] != 0){
                    break;
                }else{
                    ans[y][x] = num++;
                }

            }
            x++;
            y--;
            for (; y >= 0; y--){
                if(ans[y][x] != 0){
                    break;
                }else{
                    ans[y][x] = num++;
                }

            }
            x++;
            y++;
            if(num == n * n + 1){
                break;
            }
        }
        return ans;
    }
}