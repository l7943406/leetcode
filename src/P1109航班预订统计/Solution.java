package P1109航班预订统计;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for(int[] book : bookings){
            ans[book[0] - 1] += book[2];
            if(book[1] < n) {
                ans[book[1]] -= book[2];
            }
        }


        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }



        return ans;
    }
}
/*

这里有n个航班，它们分别从 1 到 n 进行编号。

有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。

请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。


 */