package P406根据身高重建队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list= new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][2]);
    }
}