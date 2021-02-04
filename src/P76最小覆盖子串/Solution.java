package P76最小覆盖子串;

class Solution {
    public String minWindow(String s, String t) {
        int [] book = new int['z'-'A'+2];
        init(book,t);
        int min = Integer.MAX_VALUE;
        int fromIndex = -1;
        int toIndex = -1;
        int i=0,j=0;
        int index;
        while(i<=j&&j<=s.length()){
            if(isAll(book)){
                if(j-i < min){
                    min = j-i;
                    fromIndex = i;
                    toIndex = j;
                }
                book[s.charAt(i)-'A']--;
                i++;
            }
            else{
                if(j == s.length()){
                    break;
                }

                book[s.charAt(j)-'A']++;

                j++;
            }

        }
        if(min == Integer.MAX_VALUE){
            return "";
        }else{
            return s.substring(fromIndex,toIndex);
        }
    }
    public void init(int [] book,String s){
        int n=s.length();
        for(int i=0;i<n;i++){
            book[s.charAt(i)-'A']--;
        }
    }
    public boolean isAll(int[] book){
        for(int i=0;i<'z'-'A'+2;i++){
            if(book[i]<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("aa","aa"));
    }

}