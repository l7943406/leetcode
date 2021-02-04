package P118杨辉三角;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(numRows>=1) {
            list.add(1);
            ans.add(list);
        }
        if(numRows>=2) {
            list = new ArrayList<>();
            list.add(1);
            list.add(1);
            ans.add(list);
        }
        for(int i=3;i<=numRows;i++){
            list = new ArrayList<>();
            list.add(1);
            List<Integer> last = ans.get(i-1);
            for (int j = 1 ; j < i - 1; j++){
                list.add(last.get(i)+last.get(i-1));
            }
            list.add(1);
            ans.add(list);
        }


        return ans;
    }
}