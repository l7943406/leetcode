package P374猜数字大小;


class GuessGame{
    int guess(int num){
        return 0;
    }
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long less = 1;
        long max = n;

        while (true){
            long mid = (less + max)/ 2;
            int guess = guess((int)mid);
            if(guess == 0){
                return (int)mid;
            }else if(guess == -1){
                max = mid - 1;
            }else{
                less = mid + 1;
            }
        }
    }
}