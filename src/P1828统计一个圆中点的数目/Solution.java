package P1828统计一个圆中点的数目;

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        int t = 0;
        for(int[] query : queries){
            for(int[] point : points){
                int a = query[0]-point[0];
                int b = query[1]-point[1];
                int c = query[2];
                if(a*a + b*b <= c * c){
                    answer[t]++;
                }
            }
            t++;
        }
        return answer;
    }
}