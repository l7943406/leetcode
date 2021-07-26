package P89格雷编码;

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<Integer> ans;
    boolean[] b;
    int n;

    public List<Integer> grayCode(int n) {
        this.n = n;
        this.b = new boolean[n];
        this.ans = new LinkedList<>();
        dfs(0);
        return ans;
    }

    void dfs(int index){
        if(index >= n){
            add();
            return;
        }else if(index == n - 1){
            add();
            b[index] = !b[index];
            add();
            return;
        }

        if(b[index + 1]){
            b[index + 1] = true;
            b[index] = false;
            dfs(index+2);

            b[index + 1] = true;
            b[index] = true;
            dfs(index+2);

            b[index + 1] = false;
            b[index] = true;
            dfs(index+2);

            b[index + 1] = false;
            b[index] = false;
            dfs(index+2);
        }else{
            b[index + 1] = false;
            b[index] = false;
            dfs(index+2);

            b[index + 1] = false;
            b[index] = true;
            dfs(index+2);

            b[index + 1] = true;
            b[index] = true;
            dfs(index+2);

            b[index + 1] = true;
            b[index] = false;
            dfs(index+2);
        }

    }

    void add(){
        int num = 0;
        for (int i = n - 1; i >= 0; i--) {
            num <<= 1;
            if(b[i]){
                num ++;
            }
        }
        ans.add(num);
    }
}