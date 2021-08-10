package P1122数组的相对排序;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        for(int num : arr1){
            map[num] ++;
        }
        int index = 0;
        for (int num : arr2) {
            while (map[num] -- > 0){
                arr1[index ++] = num;
            }
        }

        for (int i = 0; i < map.length; i++) {
            while (map[i] -- > 0){
                arr1[index ++] = i;
            }
        }
        return arr1;
    }
}
/*

给你两个数组，arr1 和arr2，

arr2中的元素各不相同
arr2中的每个元素都出现在arr1中
对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。

 */