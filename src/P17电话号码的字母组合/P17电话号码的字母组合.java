package P17电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> ans;
    public String digits;
    public List<String> letterCombinations(String digits) {
        this.digits=digits;
        this.ans=new ArrayList<>();
        solve("",0);
        return null;
    }
    public void solve(String s,int t){
        if(t==digits.length()+1){
            if(!"".equals(s)){
                ans.add(s);
            }
            return;
        }
        if(digits.charAt(t)=='2'){
            solve(s+"a",t+1);
            solve(s+"b",t+1);
            solve(s+"c",t+1);
        }else if(digits.charAt(t)=='3'){
            solve(s+"d",t+1);
            solve(s+"e",t+1);
            solve(s+"f",t+1);
        }else if(digits.charAt(t)=='4'){
            solve(s+"g",t+1);
            solve(s+"h",t+1);
            solve(s+"i",t+1);
        }else if(digits.charAt(t)=='5'){
            solve(s+"j",t+1);
            solve(s+"k",t+1);
            solve(s+"l",t+1);
        }else if(digits.charAt(t)=='6'){
            solve(s+"m",t+1);
            solve(s+"n",t+1);
            solve(s+"o",t+1);
        }else if(digits.charAt(t)=='7'){
            solve(s+"p",t+1);
            solve(s+"q",t+1);
            solve(s+"r",t+1);
            solve(s+"s",t+1);
        }else if(digits.charAt(t)=='8'){
            solve(s+"t",t+1);
            solve(s+"u",t+1);
            solve(s+"v",t+1);
        }else if(digits.charAt(t)=='9'){
            solve(s+"w",t+1);
            solve(s+"x",t+1);
            solve(s+"y",t+1);
            solve(s+"z",t+1);
        }
    }
}