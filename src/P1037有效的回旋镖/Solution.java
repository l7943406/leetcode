package P1037有效的回旋镖;

class Solution {
    public boolean isBoomerang(int[][] points) {
        return  !(points[0][0] == points[1][0] && points[0][1] == points[1][1] ||
                points[0][0] == points[2][0] && points[0][1] == points[2][1] ||
                points[1][0] == points[2][0] && points[1][1] == points[2][1] ||
                (points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) == (points[0][1] - points[1][1]) * (points[0][0] - points[2][0]));
    }
}
/*
回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。

给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 */