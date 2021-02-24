package P832翻转图像;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A[0].length / 2;
        for (int[] arr : A) {
            if(arr.length % 2 != 0){
                arr[n] ^= 1;
            }
            for (int i = 0; i < n; i++) {
                arr[i] ^= 1;
                arr[arr.length - i - 1] ^= 1;
                arr[i] += arr[arr.length - i - 1];
                arr[arr.length - i - 1] = arr[i] - arr[arr.length - i - 1];
                arr[i] = arr[i] - arr[arr.length - i - 1];
            }
        }
        return A;
    }
}