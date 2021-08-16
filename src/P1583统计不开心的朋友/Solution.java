package P1583统计不开心的朋友;

import java.util.Arrays;

class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] map = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                map[i][preferences[i][j]] = preferences[i].length - j;
            }
        }

        int[] unhappiness = new int[n];
        for (int i = 0; i < pairs.length - 1; i++) {
            for (int j = i + 1; j < pairs.length; j++) {
                if (unhappiness[pairs[i][0]] == 0
                        && (( map[pairs[i][0]][pairs[j][0]] >  map[pairs[i][0]][pairs[i][1]] && map[pairs[j][0]][pairs[i][0]] >  map[pairs[j][0]][pairs[j][1]])
                        || ( map[pairs[i][0]][pairs[j][1]] >  map[pairs[i][0]][pairs[i][1]] && map[pairs[j][1]][pairs[i][0]] >  map[pairs[j][1]][pairs[j][0]]))) {
                    unhappiness[pairs[i][0]] = 1;
                }
                if (unhappiness[pairs[i][1]] == 0
                        && (( map[pairs[i][1]][pairs[j][0]] >  map[pairs[i][1]][pairs[i][0]] && map[pairs[j][0]][pairs[i][1]] >  map[pairs[j][0]][pairs[j][1]])
                        || ( map[pairs[i][1]][pairs[j][1]] >  map[pairs[i][1]][pairs[i][0]] && map[pairs[j][1]][pairs[i][1]] >  map[pairs[j][1]][pairs[j][0]]))){
                    unhappiness[pairs[i][1]] = 1;
                }

                if (unhappiness[pairs[j][0]] == 0
                        && (( map[pairs[j][0]][pairs[i][0]] >  map[pairs[j][0]][pairs[j][1]] && map[pairs[i][0]][pairs[j][0]] >  map[pairs[i][0]][pairs[i][1]])
                        || ( map[pairs[j][0]][pairs[i][1]] >  map[pairs[j][0]][pairs[j][1]] && map[pairs[i][1]][pairs[j][0]] >  map[pairs[i][1]][pairs[i][0]]))) {
                    unhappiness[pairs[j][0]] = 1;
                }
                if (unhappiness[pairs[j][1]] == 0
                        && (( map[pairs[j][1]][pairs[i][0]] >  map[pairs[j][1]][pairs[j][0]] && map[pairs[i][0]][pairs[j][1]] >  map[pairs[i][0]][pairs[i][1]])
                        || ( map[pairs[j][1]][pairs[i][1]] >  map[pairs[j][1]][pairs[j][0]] && map[pairs[i][1]][pairs[j][1]] >  map[pairs[i][1]][pairs[i][0]]))){
                    unhappiness[pairs[j][1]] = 1;
                }
            }
        }


        int ans = 0;
        for(int unhappy : unhappiness){
            ans += unhappy;
        }
        return ans;
    }

}
/*

给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。

对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。

所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。

但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：

x 与 u 的亲近程度胜过 x 与 y，且
u 与 x 的亲近程度胜过 u 与 v
返回 不开心的朋友的数目 。

 */