package P1105填充书架;

import java.util.Arrays;

class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int ans = 0;
        Arrays.sort(books,( a, b) -> b[1] - a[1]);
        int now;

        for (int i = 0; i < books.length; i++) {
            if(books[i][0] != -1){
                now = books[i][0];
                ans += books[i][1];
                books[i][0] = -1;
                for (int j =  i + 1; j < books.length && now != shelf_width; j++) {
                    if(books[j][0] != -1 && books[j][0] + now <= shelf_width){
                        now += books[j][0];
                        books[j][0] = -1;
                    }
                }
            }
        }
        return ans;
    }
}
/*

附近的家居城促销，你买回了一直心仪的可调节书架，打算把自己的书都整理到新的书架上。

你把要摆放的书 books都整理好，叠成一摞：从上往下，第 i本书的厚度为 books[i][0]，高度为 books[i][1]。

按顺序将这些书摆放到总宽度为shelf_width 的书架上。

先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelf_width），然后再建一层书架。重复这个过程，直到把所有的书都放在书架上。

需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。 例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。

每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。

以这种方式布置书架，返回书架整体可能的最小高度。

 */

/*
7 7 5 3
8 2 2 7


7+

* */