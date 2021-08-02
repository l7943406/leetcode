package P519随机翻转矩阵;

import java.util.*;

class Solution {
    int index;
    int m;
    int n;
    Integer[] map;

    public Solution(int m, int n) {
        this.map = new Integer[m];
        this.m = m;
        this.n = n;
        for (int i = 0; i < map.length; i++) {
            map[i] = i * n;
        }

        Arrays.sort(map, (o1, o2) -> new Random().nextInt(10) - 5);
        this.index = new Random().nextInt(m);
    }

    public int[] flip() {
        int random = map[index % map.length];
        index++;
        return new int[]{random % m,random/ m };
    }

    public void reset() {
        this.index = new Random().nextInt(n * m);
    }
}

/*

题中给出一个 n_rows 行 n_cols 列的二维矩阵，且所有值被初始化为 0。

要求编写一个 flip 函数，均匀随机的将矩阵中的 0 变为 1，并返回该值的位置下标 [row_id,col_id]；

同样编写一个 reset 函数，将所有的值都重新置为 0。
尽量最少调用随机函数 Math.random()，并且优化时间和空间复杂度。

 */