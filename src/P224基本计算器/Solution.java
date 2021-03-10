package P224基本计算器;

class Solution {
    public int calculate(String s) {
        s = "(" + s + ")";
        return calculate(s,0,new int[1]);
    }
    public int calculate(String s , int start ,int[] end) {
        int ans = 0;
        int now = 0;
        boolean add = true;
        for (int i = start; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                int[] e = new int[1];
                ans = opera(ans,calculate(s,i+1,e),add);
                i = e[0];
            }else if(s.charAt(i) == ')'){
                ans = opera(ans,now,add);
                end[0] = i;
                return ans;
            }else if(s.charAt(i) == '+'){
                ans = opera(ans,now,add);
                now = 0;
                add = true;
            }else if(s.charAt(i) == '-'){
                ans = opera(ans,now,add);
                now = 0;
                add = false;
            } else if(s.charAt(i) == ' '){
                ans = opera(ans,now,add);
                now = 0;
            }else{
                now *= 10;
                now += s.charAt(i) - '0';
            }
        }
        return ans;
    }
    public int opera(int num1,int num2,boolean add){
        if(add){
            return num1 + num2;
        }else{
            return num1 - num2;
        }
    }
}