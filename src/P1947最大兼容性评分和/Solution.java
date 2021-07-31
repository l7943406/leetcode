package P1947最大兼容性评分和;

class Solution {
    boolean[] book;
    int ans = 0;
    int[][] map;
    int m;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        this.m = students.length;
        this.book = new boolean[m];
        this.map = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = comp(students[i],mentors[j]);
            }
        }

        dfs(0,0);
        return ans;
    }
    private int comp(int[] nums1,int[] nums2){
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i] == nums2[i]){
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int step,int score){
        if(step == m){
            ans = Math.max(score,ans);
            return;
        }
        for (int i = 0; i < m; i++) {
            if(!book[i]){
                book[i] = true;
                dfs(step + 1,score + map[step][i]);
                book[i] = false;
            }
        }

    }
}
/*
有一份由 n 个问题组成的调查问卷，每个问题的答案要么是 0（no，否），要么是 1（yes，是）。

这份调查问卷被分发给 m 名学生和 m 名导师，学生和导师的编号都是从 0 到 m - 1 。学生的答案用一个二维整数数组 students 表示，
其中 students[i] 是一个整数数组，包含第 i 名学生对调查问卷给出的答案（下标从 0 开始）。导师的答案用一个二维整数数组 mentors 表示，
其中 mentors[j] 是一个整数数组，包含第 j 名导师对调查问卷给出的答案（下标从 0 开始）。

每个学生都会被分配给 一名 导师，而每位导师也会分配到 一名 学生。配对的学生与导师之间的兼容性评分等于学生和导师答案相同的次数。

例如，学生答案为[1, 0, 1] 而导师答案为 [0, 0, 1] ，那么他们的兼容性评分为 2 ，因为只有第二个和第三个答案相同。
请你找出最优的学生与导师的配对方案，以 最大程度上 提高 兼容性评分和 。

给你 students 和 mentors ，返回可以得到的 最大兼容性评分和 。

 */