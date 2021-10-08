package P419甲板上的战舰;

class Solution {
    public int countBattleships(char[][] board) {
        int ans = 0;
        if(board[0][0] == 'X'){
            ans++;
        }
        for (int i = 1; i < board.length; i++) {
            if(board[i][0] == 'X' && board[i-1][0] == '.'){
                ans++;
            }
        }
        for (int i = 1; i < board[0].length; i++) {
            if(board[0][i] == 'X' && board[0][i-1] == '.'){
                ans++;
            }
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if(board[i][j] == 'X' && board[i][j - 1] == '.' && board[i - 1][j] == '.') {
                    ans++;
                }
            }
        }
        return ans;
    }
}
/*
给定一个二维的甲板， 请计算其中有多少艘战舰。
战舰用'X'表示，空位用'.'表示。你需要遵守以下规则：

给你一个有效的甲板，仅由战舰或者空位组成。
战舰只能水平或者垂直放置。换句话说,战舰只能由1xN (1 行, N 列)组成，或者Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
两艘战舰之间至少有一个水平或垂直的空位分隔- 即没有相邻的战舰。
 */