package P297二叉树的序列化与反序列化;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
class Codec {
    private StringBuilder s;
    public String serialize(TreeNode root) {
        s = new StringBuilder();
        traversalSerialize(root);
        return s.toString();
    }
    private void traversalSerialize(TreeNode root){
        if(root == null){
            s.append('n');
            return;
        }
        s.append(root.val)
                .append('[');
        traversalSerialize(root.left);
        s.append(',');
        traversalSerialize(root.right);
        s.append(']');
    }

    public TreeNode deserialize(String data) {
        return traversalDeserialize(data.getBytes(), 0, data.length());
    }
    private TreeNode traversalDeserialize(byte[] data, int start, int end){
        if(data[start] == 'n'){
            return null;
        }
        int ride = 1;
        if(data[start] == '-'){
            ride = -1;
            start++;
        }
        int val = 0;
        for (int i = start; i < end; i++) {
            if(data[i] > '9' || data[i] < '0'){
                start = i + 1;
                break;
            }
            val *= 10;
            val += data[i] - '0';
        }
        int t = 0;
        int stack = 0;
        for (int i = start; i < end; i++) {
            if(data[i] == '['){
                stack ++;
            }else if(data[i] == ']'){
                stack --;
            }else if(data[i] == ','){
                if(stack == 0){
                    t = i;
                    break;
                }
            }
        }



        TreeNode node = new TreeNode(val * ride);
        node.left = traversalDeserialize(data,start,t);
        node.right = traversalDeserialize(data, t + 1, end);
        return node;


    }
}

