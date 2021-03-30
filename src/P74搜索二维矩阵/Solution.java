package P74搜索二维矩阵;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;
        int mid = 0;
        while (l <= r){
            mid = (l + r) / 2;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        if(l - 1 >= matrix.length || l - 1 < 0){
            return false;
        }
        return search(matrix[l - 1],target);
    }
    public boolean search(int[] arr,int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        },3));
    }
}