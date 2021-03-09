package P1047删除字符串中的所有相邻重复项;

/*class Solution {
    public String removeDuplicates(String S) {
        for (int i = 1; i < S.length(); i++) {
            if(S.charAt(i) == S.charAt(i-1)){
                return removeDuplicates(S.substring(0,i-1)+S.substring(i+1));
            }
        }
        return S;
    }
}*/
/*
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == S.charAt(i)){
                stack.pop();
            }else{
                stack.push(S.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char c : stack){
            ans.append(c);
        }
        return ans.toString();
    }
}*/
class Solution {
    public String removeDuplicates(String S) {
        char[] s = new char[S.length()];
        int top = 0;
        s[top ++] = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if(top > 0 && S.charAt(i) == s[top - 1]){
                top --;
            }else{
                s[top++] = S.charAt(i);
            }
        }
        return String.valueOf(s,0,top);
    }
}