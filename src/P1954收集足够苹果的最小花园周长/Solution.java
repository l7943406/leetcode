package P1954收集足够苹果的最小花园周长;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long minimumPerimeter(long neededApples) {
        long perimeter = 0L;
        long apples = 0L;
        while (apples < neededApples){
            perimeter ++;
            apples += perimeter * perimeter * 12;
        }
        return perimeter * 8;
    }
}
