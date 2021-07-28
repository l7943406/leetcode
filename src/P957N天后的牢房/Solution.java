package P957N天后的牢房;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[] map1 = new int[cells.length];
        int[] map2 = new int[cells.length];
        for (int i = 0; i < ; i++) {

        }
    }
}
/*
8 间牢房排成一排，每间牢房不是有人住就是空着。

每天，无论牢房是被占用或空置，都会根据以下规则进行更改：

如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
否则，它就会被空置。
（请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）

我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。

根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）

 */