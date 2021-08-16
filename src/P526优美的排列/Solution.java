package P526优美的排列;

class Solution {
    boolean[] book;
    int ans;
    public int countArrangement(int n) {
        this.book = new boolean[n + 1];
        this.ans = 0;
        dfs(1);
        return ans;
    }
    private void dfs(int step){
        if(step == book.length){
            ans++;
            return;
        }
        for (int i = 1; i < book.length; i++) {
            if(!book[i]){
                if(step % i == 0 || i % step == 0){
                    book[i] = true;
                    dfs(step + 1);
                    book[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(new Solution().countArrangement(i));
        }
    }
}




/*

假设有从 1 到 N 的N个整数，如果从这N个数字中成功构造出一个数组，使得数组的第 i位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

第i位的数字能被i整除
i 能被第 i 位上的数字整除
现在给定一个整数 N，请问可以构造多少个优美的排列？

 */