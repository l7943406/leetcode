package P79单词搜索;

class Solution {
    int[][] next={{1,0},{0,1},{-1,0},{0,-1}};
    char[][] board;
    boolean[][] book;
    String word;
    boolean isTrue;
    public boolean exist(char[][] board, String word) {
        if(board.length*board[0].length<word.length()) {
            return false;
        }
        this.board = board;
        this.word = word;
        this.book = new boolean[board.length][board[0].length];
        this.isTrue = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    book[i][j]=true;
                    dfs(i,j,0);

                    book[i][j]=false;
                }
            }
        }
        return isTrue;
    }
    public void dfs(int x,int y,int index){

        if(isTrue){
            return;

        }
        if(index == word.length()-1){

            if(word.charAt(index) == board[x][y]){
                isTrue = true;
            }

        }
        else {
            for (int i = 0; i < 4; i++) {
                int sx, sy;
                sx = x + next[i][0];
                sy = y + next[i][1];
                if (sx >= 0 && sy >= 0 && sx < board.length && sy < board[0].length) {
                    if (!book[sx][sy]) {
                        if (board[sx][sy] == word.charAt(index + 1)) {
                            book[sx][sy] = true;
                          //  System.out.print(board[sx][sy]);
                            dfs(sx, sy, index + 1);
                            book[sx][sy] = false;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','b'}},"aaaaaaaaaaaaaaaaaaaa"));
    }

}