package P1654到家的最少跳跃次数;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        boolean[] go = new boolean[6001];
        boolean[] back = new boolean[6001];

        Map<Integer, Object> map = new HashMap<>();
        for (int i : forbidden) {
            map.put(i, null);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(-1);
        int step = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            //System.out.println(now);
            if (now == x) {
                return step;
            } else if (now > 6000) {

            } else if (now == -1) {
                if (!queue.isEmpty()) {
                    queue.add(-1);
                }
                step++;
            } else if (now == -2) {
                now = queue.poll();
                if (now == x) {
                    return step;
                }
                if (!go[now] && !map.containsKey(now + a)) {
                    queue.add(now + a);
                    go[now] = true;
                }
            } else {
                if (!go[now] && !map.containsKey(now + a)) {
                    queue.add(now + a);
                    go[now] = true;
                }
                if (!back[now] && now - b >= 0 && !map.containsKey(now - b)) {
                    queue.add(-2);
                    queue.add(now - b);
                    back[now] = true;
                }
            }
        }
        return -1;
    }


}