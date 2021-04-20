package P28实现strStr;

//最快
/*
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}*/

// bf
/*
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack == null || haystack.length()==0){
            return -1;
        }
        byte[] h = haystack.getBytes();
        byte[] n = needle.getBytes();
        for (int i = 0; i <= h.length - n.length; i++) {
            boolean find = true;
            for (int j = 0; j < n.length; j++) {
                if(h[i + j] != n[j]){
                    find = false;
                    break;
                }
            }
            if(find){
                return i;
            }
        }
        return -1;
    }
}*/
/*
* kmp
* */
/*
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack == null || haystack.length()==0){
            return -1;
        }
        byte[] h = haystack.getBytes();
        byte[] n = needle.getBytes();
        int[] next = new int[needle.length()];
        for (int i = 1,j = 0; i < n.length; i++) {
            while (j > 0 && n[i] != n[j]){
                j = next[j - 1];
            }
            if(n[i] == n[j]){
                j++;
            }
            next[i] = j;
        }
        int j = 0;
        for (int i = 0; i < h.length; i++) {
            while (j > 0 && h[i] != n[j]){
                j = next[j - 1];
            }
            if(n[j] == h[i]){
                j++;
            }
            if(j == n.length){
                return i - j + 1;
            }
        }
        return -1;
    }

}*/