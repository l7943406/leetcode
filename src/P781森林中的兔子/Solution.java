package P781森林中的兔子;


class Solution {
    public int numRabbits(int[] answers) {
        int ans = 0;
        int[] book = new int[1000];
        for (int answer : answers) {
            book[answer]++;
        }
        ans += book[0];
        for (int i = 1; i < book.length; i++) {
            if(book[i] != 0){
                ans += (book[i] / (i + 1)) * (i + 1);
                if(book[i] % (i + 1) != 0){
                    ans += i + 1;
                }
            }
        }
        return ans;
    }
}