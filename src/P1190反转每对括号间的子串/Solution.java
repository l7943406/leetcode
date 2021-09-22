package P1190反转每对括号间的子串;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String reverseParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        byte[] bytes = s.getBytes();
        int count = 0;
        Deque<Byte> deque = new LinkedList<>();
        Deque<Byte> deque1 = new LinkedList<>();
        for(byte c : bytes) {
            if(c == '('){
                count ++;
                while (!deque1.isEmpty()){
                    deque.addFirst(deque1.pollLast());
                }
            }else if(c == ')'){
                count --;
                while (!deque1.isEmpty()){
                    deque.addFirst(deque1.pollLast());
                }
            }else{
                if((count & 1) == 0){
                    deque1.addLast(c);
                }else{
                    deque.addFirst(c);
                }
            }
        }
        while (!deque.isEmpty()){
            ans.append((char) deque.pollFirst().byteValue());
        }

        return ans.toString();
    }
}