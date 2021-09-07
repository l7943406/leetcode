package P470用Rand7实现Rand10;

import java.util.Arrays;
import java.util.Random;

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class SolBase{
    public int rand7(){
        return new Random().nextInt(7) + 1;
    }
}
class Solution extends SolBase {
    public int rand10() {
        int rand = (rand7() - 1) * 7 + rand7();
        return rand <= 40 ? (rand - 1) % 10 + 1: rand10();
    }
}
/*

1 2 3 4 5 6 7
1 - 49

* */