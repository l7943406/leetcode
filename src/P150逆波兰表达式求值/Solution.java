package P150逆波兰表达式求值;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a,b;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]){
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(a + b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(a * b);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b / a);
                    break;
                default:
                    stack.add(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return  stack.pop();
    }
}