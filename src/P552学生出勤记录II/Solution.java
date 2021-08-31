package P552学生出勤记录II;

import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public int checkRecord(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007 + dp[i - 3] % 1000000007;
        }
        System.out.println(dp[n]);
        return 0;
    }

    public static void main(String[] args) {
        new Solution().checkRecord(10101);
    }
}

/*
0 1 1 2 4 7 13 24

1 2  3   4    5
P PP PPP PPPP PPPPP
L PL PPL PPPL PPPPL
  LP PLP PPLP PPPLP
  LL PLL PPLL PPPLL
     LPP PLPP PPLPP
     LPL PLPL PPLPL
     LLP PLLP PPLLP
         LPPP PLPPP
         LPPL PLPPL
         LPLP PLPLP
         LPLL PLPLL
         LLPP PLLPP
         LLPL PLLPL
              LPPPP
              LPPPL
              LPPLP
              LPPLL
              LPLPP
              LPLPL
              LPLLP
              LLPPP
              LLPPL
              LLPLP
              LLPLL





A 最多一个
L 最多连续俩
P 到了
1 2
2 4
3 7
4 13
5 25

1
P
L

2
PP
LP PL
LL

3
PPP
PPL PLP LPP
PLL LPL LLP

4
PPPP
PPPL PPLP PLPP LPPP
PPLL PLPL LPPL PLLP LPLP LLPP
LPLL LLPL

5
PPPPP
PPPPL PPPLP PPLPP PLPPP LPPPP
LLPPP LPLPP LPPLP LPPPL PLLPP PLPLP PLPPL PPLLP PPLPL PPPLL
LLPLP LLPPL LPLLP LPLPL LPPLL PLLPL PLPLL
LLPLL



 */