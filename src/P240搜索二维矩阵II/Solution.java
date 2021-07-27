package P240搜索二维矩阵II;


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length > matrix[0].length){
            for (int i = 0; i < matrix[0].length; i++) {
                int l = 0;
                int r = matrix.length - 1;
                while (l <= r){
                    int mid = (l + r) / 2;
                    if(matrix[mid][i] < target){
                        l = mid + 1;
                    }else if(matrix[mid][i] > target){
                        r = mid - 1;
                    }else{
                        return true;
                    }
                }
            }
        }else{
            for (int[] arr : matrix) {
                int l = 0;
                int r = arr.length - 1;
                while (l <= r){
                    int mid = (l + r) / 2;
                    if(arr[mid] < target){
                        l = mid + 1;
                    }else if(arr[mid] > target){
                        r = mid - 1;
                    }else{
                        return true;
                    }
                }
            }
        }

        return false;
    }


}
