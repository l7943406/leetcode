package P218天际线问题;


import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new LinkedList<>();
        PriorityQueue<int[]> heightQueue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        ArrayList<Pair> lineQueue = new ArrayList<>();
        for (int[] build : buildings) {
            lineQueue.add(new Pair(false, build));
            lineQueue.add(new Pair(true, build));
        }
        lineQueue.sort(Comparator.comparingInt(Pair::get));
        int index = 0;
        int max = 0;
        heightQueue.add(new int[]{0, 0, 0});
        while (index < lineQueue.size()) {
            Pair now = lineQueue.get(index ++);
            while (index < lineQueue.size() && lineQueue.get(index).get() == now.get()){
                Pair and = lineQueue.get(index ++);
                if (and.isEnd) {
                    heightQueue.remove(and.build);
                } else {
                    heightQueue.add(and.build);
                }
            }
            if (now.isEnd) {
                heightQueue.remove(now.build);
            } else {
                heightQueue.add(now.build);
            }
            int[] highest = heightQueue.peek();
            if (highest[2] != max) {
                max = highest[2];
                List<Integer> list = new LinkedList<>();
                list.add(now.isEnd ? now.build[1] : now.build[0]);
                list.add(highest[2]);
                ans.add(list);
            }
        }
        return ans;
    }

    public static class Pair {

        public boolean isEnd;
        public int[] build;

        public Pair(boolean isEnd, int[] build) {
            this.isEnd = isEnd;
            this.build = build;
        }

        public int get() {
            return isEnd ? build[1] : build[0];
        }

    }

}