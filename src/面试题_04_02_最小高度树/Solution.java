package 面试题_04_02_最小高度树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return creatTree(nums,0,nums.length - 1);
    }
    public TreeNode creatTree(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = creatTree(nums,left,mid-1);
        root.right = creatTree(nums,mid+1,right);
        return root;
    }
}

/*创建包时包名末尾有空格会导致无法识别包*/