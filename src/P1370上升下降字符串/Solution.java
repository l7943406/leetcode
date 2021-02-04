package P1370上升下降字符串;

class Solution {
    public String sortString(String s) {
        int[] num = new int[26];
        byte[] ans = new byte[s.length()];
        int t=0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i)-'a']++;
            max = Math.max(max,num[s.charAt(i)-'a']);
        }
        for (int i = 0; i < max; i++) {
            if(i%2 == 0){
                for(int j=0;j<26;j++){
                    if(num[j]!=0){
                        num[j]--;
                        ans[t++]= (byte) ('a'+j);
                    }
                }
            }else{
                for(int j=25;j>=0;j--){
                    if(num[j]!=0){
                        num[j]--;
                        ans[t++]= (byte) ('a'+j);
                    }
                }
            }
        }
        return new String(ans);
    }

}