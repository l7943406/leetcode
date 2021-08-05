package 剑指Offer37序列化二叉树;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
@SuppressWarnings("all")


class Codec {
    private StringBuilder s;
    public String serialize(TreeNode root) {
        s = new StringBuilder(5000);
        dfs(root);
        return s.toString();
    }
    private void dfs(TreeNode root){
        if(root == null){
            s.append("[n]");
            return;
        };
        s.append('[').append(root.val).append(':');
        dfs(root.left);
        dfs(root.right);
        s.append(']');
    }


    public TreeNode deserialize(String data) {
        return solve(data.getBytes(),1,data.length() - 2);
    }
    private TreeNode solve(byte[] s, int start, int end){
        if(s[start] == 'n'){
            return null;
        }
        int val = 0;
        int fu = 1;
        if(s[start] == '-'){
            fu = -1;
            start++;
        }
        for (; start <= end; start++) {
            if(s[start] == ':'){
                start++;
                break;
            }
            val *= 10;
            val += s[start] - '0';
        }
        int tt = start + 1;
        val *= fu;
        fu = 0;
        for (; start <= end; start++) {
            if(s[start] == '['){
                fu++;
            }else if(s[start] == ']'){
                fu --;
            }
            if(fu == 0){
                break;
            }
        }
        TreeNode result = new TreeNode(val);
        result.left = solve(s,tt,start - 1);
        result.right = solve(s,start + 2,end);
        return result;
    }
}
