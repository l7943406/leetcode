package P802找到最终的安全状态;

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> ends = new LinkedList<>();
        Map<Integer,Object> book = new HashMap<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if(graph[i].length == 0){
                ends.add(i);
                book.put(i,null);
            }else{
                for (int j = 0; j < graph[i].length; j++) {
                    map.putIfAbsent(graph[i][j],new LinkedList<>());
                    map.get(graph[i][j]).add(i);
                }
            }
        }


        int last = 0;
        List<Integer> removeList = new LinkedList<>();
        while (last != ends.size()){
            last = ends.size();
            List<Integer> newL = new LinkedList<>();
            for(Integer end : ends){
                if(map.containsKey(end)){
                    for(Integer next : map.get(end)){
                        if(!book.containsKey(next)){
                            book.put(next,null);
                            newL.add(next);
                        }else{
                            removeList.add(next);
                        }
                    }
                }
            }
            ends.addAll(newL);
        }
        ends.removeAll(removeList);










        ends.sort(Comparator.comparingInt(a -> a));
        return ends;
    }
}
/*

在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。

对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。

返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。

该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是graph的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。

 */