package 面试题0809括号Q;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String,Integer> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("",n);
        return ans;
    }
    public void dfs(String now, int n){
        if(map.containsKey(now)){
            return;
        }else{
            map.put(now,0);
            if(n == 0){
                ans.add(now);
                return;
            }
        }
        for (int i = 0; i <= now.length(); i++) {
            dfs(now.substring(0,i)+"()"+now.substring(i),n-1);
        }
    }

    public static void main(String[] args) {
        new Solution().generateParenthesis(3);
    }
}

//["(())(())"]