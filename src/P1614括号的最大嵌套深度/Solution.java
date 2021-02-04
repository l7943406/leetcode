package P1614括号的最大嵌套深度;

class Solution {
    public int maxDepth(String s) {
        if(s==null){
            return  0;
        }
        int max = 0;
        int t = 0;
        for(int i=0;i<s.length();i++){
            max = Math.max(max,t);
            if(s.charAt(i)=='('){
                t++;
            }else if(s.charAt(i)==')'){
                t--;
            }
        }
        return max;
    }
}