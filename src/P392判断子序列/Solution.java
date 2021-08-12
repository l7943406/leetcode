package P392判断子序列;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.isEmpty()){
            return true;
        }
        if(t == null || t.isEmpty()){
            return false;
        }





        int index = 0;
        byte[] sb = s.getBytes();
        for(byte c : t.getBytes()){
            if(c == sb[index]){
                index++;
                if(index == sb.length){
                    return true;
                }
            }
        }

        return false;


    }
}