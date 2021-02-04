package P557反转字符串中的单词Ⅲ;

class Solution {
    public String reverseWords(String s) {
        byte[] x = s.getBytes();
        int last = 0;
        for (int i = 0; i < x.length; i++) {
            if(x[i] == ' '){
                swap(x,last,i-1);
                last = i+1;
            }
        }
        swap(x,last,x.length-1);
        return new String(x);
    }
    public void swap(byte[] s,int l,int r){
        while(l<r){
            byte t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}