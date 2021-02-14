package P765情侣牵手;

class Solution {
    public int minSwapsCouples(int[] row) {
        int ans = 0;
        int[] index = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            index[row[i]] = i;
        }
        for (int i = 0; i < row.length; i+=2) {
            int couple = couple(row[i]);
            if(index[couple] != i+1){
                row[index[couple]] = row[i + 1];
                index[row[i + 1]] =  index[couple];
                ans++;
            }
        }
        return ans;
    }
    private int couple(int i){
        return i % 2 == 0 ? i + 1: i - 1;
    }
}