package 面试题计算器;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Character> stack1 = new Stack<>();
        Queue<Object> queue = new LinkedList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == '+'){
                while (!stack1.isEmpty()&&needMove(stack1.peek(),'+')){
                    queue.add(stack1.pop());
                }
                stack1.push('+');
            }else if(c == '-'){
                while (!stack1.isEmpty()&&needMove(stack1.peek(),'-')){
                    queue.add(stack1.pop());
                }
                stack1.push('-');
            }else if(c == '*'){
                stack1.push('*');
            }else if(c == '/'){
                stack1.push('/');
            }else if(c=='('){
                stack1.push('(');
            }else if(c==')'){
                while(stack1.peek()!=')'){
                    queue.add(stack1.pop());
                }
                stack1.pop();
            }else if(c != ' '){
                int num = 0;
                int first = 0;
                int end = i;
                for(; i >= 0; i--){
                    if(s.charAt(i)>'9'||s.charAt(i)<'0'){
                        first = i+1;
                        i++;
                        break;
                    }
                }
                for (int j = first; j <= end; j++) {
                    num *= 10;
                    num += s.charAt(j) - '0';
                }
                queue.add(num);
            }
        }
        while(!stack1.isEmpty()){
            queue.add(stack1.pop());
        }
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            if(queue.peek().getClass().isInstance(0)){
                stack.push((Integer) queue.poll());
            }else{
                char o = (Character) queue.poll();
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(opera(num1,o,num2));
            }
        }
        return stack.pop();
    }
    public boolean needMove(char stack,char now){
        if(now=='+'||now =='-'){
            return stack == '*' || stack == '/';
        }
        return false;
    }
    public int opera(int num1,char o,int num2){
        switch (o){
            case '+':return num1 + num2;
            case '-':return num1 - num2;
            case '*':return num1 * num2;
            case '/':return num1 / num2;
        }
        return 0;
    }

}