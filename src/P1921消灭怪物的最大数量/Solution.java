package P1921消灭怪物的最大数量;


class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            dist[i] += speed[i] - 1;
            dist[i] /= speed[i];
            max = Math.max(max,dist[i]);
            min = Math.min(min,dist[i]);
        }
        int[] sort = new int[max - min + 1];
        for (int i : dist) {
            sort[i - min] ++;
        }
        int ans = 0;
        for (int i = 0; i < sort.length; i++) {
            if(sort[i] > 0) {
                for (int j = 0; j < sort[i]; j++) {
                    if (i + min <= ans) {
                        return ans;
                    }
                    ans++;
                }
            }
        }

        return ans;
    }
}
