package P743网络延迟时间;


import java.util.*;

@SuppressWarnings("all")
class Solution2 {


    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(( a, b) -> { return a[1] - b[1]; });
        Map<Integer, List<int[]>> map = new HashMap<>();
        List<int[]> defList = new LinkedList<>();
        int[] finded = new int[n + 1];
        Arrays.fill(finded,Integer.MAX_VALUE);



        for(int i = 0; i < times.length; i++){
            map.putIfAbsent(times[i][0],new LinkedList<>());
            map.get(times[i][0]).add(times[i]);
        }


        queue.offer(new int[]{k,0});

        int step = 0;

        while (!queue.isEmpty() && step < n){
            int[] now = queue.poll();
            if(finded[now[0]] != Integer.MAX_VALUE){
                continue;
            }
            step ++;
            finded[now[0]] = now[1];
            for(int[] time : map.getOrDefault(now[0],defList )){
                if(finded[time[1]] == Integer.MAX_VALUE) {
                    queue.offer(new int[]{time[1], now[1] + time[2]});
                }
            }
        }




        int ans = 0;
        finded[0] = 0;
        for(int i : finded){
            ans = Math.max(ans,i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}