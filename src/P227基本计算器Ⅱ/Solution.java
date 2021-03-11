package P227基本计算器Ⅱ;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Character last = null;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case '+':
                    if(last != null){
                        if(last == '-'){
                            stack.push(-num);
                        }else{
                            int num1 = stack.pop();
                            stack.push(opera(num1, num,last));
                        }
                        last = null;
                    }else{
                        stack.push(num);
                    }
                    num = 0;
                    break;
                case '-':
                    if(last != null){
                        if(last == '-'){
                            stack.push(-num);
                        }else{
                            int num1 = stack.pop();
                            stack.push(opera(num1, num,last));
                        }
                    }else{
                        stack.push(num);
                    }
                    num = 0;
                    last = '-';
                    break;
                case '*':
                    if(last != null){
                        if(last == '-'){
                            stack.push(-num);
                        }else{
                            int num1 = stack.pop();
                            stack.push(opera(num1, num,last));
                        }
                    }else{
                        stack.push(num);
                    }
                    num = 0;
                    last = '*';
                    break;
                case '/':
                    if(last != null){
                        if(last == '-'){
                            stack.push(-num);
                        }else{
                            int num1 = stack.pop();
                            stack.push(opera(num1, num,last));
                        }
                    } else{
                        stack.push(num);
                    }
                    num = 0;
                    last = '/';
                    break;
                case ' ':continue;
                default:
                    num *= 10;
                    num += s.charAt(i) - '0';
            }
        }
        if(last != null){
            if(last == '-'){
                stack.push(-num);
            }else{
                int num1 = stack.pop();
                stack.push(opera(num1, num,last));
            }
        }else{
            stack.push(num);
        }
        int ans = 0;
        for (int i : stack) {
            ans += i;
        }
        return ans;
    }
    public Integer opera(Integer num1,Integer num2,Character c){
        if(c == '*'){
            return num1 * num2;
        }else if(c == '/'){
            return num1 / num2;
        }else {
            return 0;
        }
    }
}