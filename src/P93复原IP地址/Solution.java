package P93复原IP地址;

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> ans;
    int[] nums;
    public List<String> restoreIpAddresses(String s) {
        this.ans = new LinkedList<>();
        this.nums = new int[4];
        dfs(s.getBytes(), 0, 0);
        return ans;
    }
    private void dfs(byte[] s, int index, int step){
        if(step == 4 && index == s.length){
            StringBuilder sb = new StringBuilder();
            sb.append(nums[0]).append('.').append(nums[1]).append('.').append(nums[2]).append('.').append(nums[3]);
            ans.add(sb.toString());
        }
        if(step == 4){
            return;
        }
        if(index >= s.length){
            return;
        }
        if(s[index] == '0'){
            nums[step] = 0;
            dfs(s, index + 1, step + 1);
            return;
        }

        int num = 0;
        for (int i = index; i < s.length; i++) {
            num *= 10;
            num += s[i] - '0';
            if(num <= 255){
                nums[step] = num;
                dfs(s, i + 1, step + 1);
            }else{
                break;
            }
        }
    }

}
/*给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。

有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
*/