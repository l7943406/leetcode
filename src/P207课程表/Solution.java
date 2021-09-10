package P207课程表;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] list = new LinkedList[numCourses];
        int[] in = new int[numCourses];
        //init
        for (int[] prerequisite : prerequisites) {
            if(list[prerequisite[0]] == null){
                list[prerequisite[0]] = new LinkedList();
            }
            list[prerequisite[0]].add(prerequisite[1]);
            in[prerequisite[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        LinkedList<Integer> emptyList = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < in.length; i++) {
            if(list[i] == null){
                list[i] = emptyList;
            }
            if(in[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int p = queue.poll();
            count++;
            for (int i : list[p]) {
                in[i] --;
                if(in[i] == 0){
                    queue.add(i);
                }
            }
        }
        return count == numCourses;

    }
}
/*
    你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
    在选修某些课程之前需要一些先修课程。
    先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
    例如，先修课程对[0, 1] 表示 : 想要学习课程 0 ，你需要先完成课程 1 。
    请你判断是否可能完成所有课程的学习？
    如果可以，返回 true ；否则，返回 false 。
 */