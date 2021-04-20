package P1356根据数字二进制下1的数目排序;


import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] e = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            e[i] = arr[i];
        }
        Arrays.sort(e,0,arr.length,new mycmp());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = e[i];
        }
        return arr;
    }
}

class mycmp implements Comparator<Integer>  //implements 也可以不写，但是把变量转换成Object的he类型
{
    public static Map<Integer,Integer> map;
    public mycmp(){
        map = new HashMap<>();
    }

    @Override
    public int compare(Integer A, Integer B)  //cmp
    {
        int a = findOne(A);
        int b = findOne(B);
        if(a == b){
            return A-B;
        }else{
            return a-b;
        }
    }
    public int findOne(Integer t){
        if(map.containsKey(t)){
            return map.get(t);
        }else{
            int tt=t;
            int one  = 0;
            while(t!=0){
                if(t%2==1){
                    one++;
                }
                t/=2;
            }
            map.put(tt,one);
            return one;
        }


    }
}
