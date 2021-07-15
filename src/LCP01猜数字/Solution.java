package LCP01猜数字;

public class Solution {
    public int game(int[] guess, int[] answer) {

        //hanhan操作
        if(guess[0] == answer[0]){
            if(guess[1] == answer[1]){
                if(guess[2] == answer[2]){
                    return 3;
                }
                else{
                    return 2;
                }
            }else{
                if(guess[2] == answer[2]){
                    return 2;
                }
                else{
                    return 1;
                }
            }
        }else{
            if(guess[1] == answer[1]){
                if(guess[2] == answer[2]){
                    return 2;
                }
                else{
                    return 1;
                }
            }else{
                if(guess[2] == answer[2]){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hello 。。。");
    }
}