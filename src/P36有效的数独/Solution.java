package P36有效的数独;

import java.util.Arrays;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] map1 = new int[9];
        int[] map2 = new int[9];
        for (int i = 0; i < 9; i++) {

            Arrays.fill(map1,0);
            Arrays.fill(map2,0);

            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    map1[board[i][j] - '1'] ++;
                }
                if(board[j][i] != '.'){
                    map2[board[j][i] - '1'] ++;
                }
            }

            for (int j = 0; j < 9; j++) {
                if(map1[j] > 1 || map2[j] > 1){
                    return false;
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                Arrays.fill(map1,0);
                for (int l = j * 3; l < (j + 1) * 3; l++) {
                    for (int m = k * 3; m < (k + 1) * 3; m++) {
                        if(board[l][m] != '.'){
                            map1[board[l][m] - '1'] ++;
                        }
                    }
                }
                for (int l = 0; l < 9; l++) {
                    if (map1[l] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}