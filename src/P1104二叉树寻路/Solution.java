package P1104二叉树寻路;

import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int floor = floor(label);
        if(floor % 2 == 0){
            label = (1 << floor - 1) + (1 << floor) - 1  - label;
        }
        Integer[] normal = new Integer[floor];
        normal[floor - 1] = label;
        for (int i = floor - 2; i >= 0; i--) {
            normal[i] = normal[i + 1] / 2;
        }
        for (int i = 0; i < floor; i++) {
            if(i % 2 == 1){
                normal[i] = (1 << i) + (1 << i + 1) - 1  - normal[i];
            }
        }
        return Arrays.asList(normal);
    }
    public int floor(int label){
        int floor = 0;
        int sum = 0;
        while (sum < label){
            sum += 1 << floor++;
        }
        return floor;
    }
}
/*
在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。

如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；

而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。

给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 */