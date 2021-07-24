package P1736替换隐藏数字得到的最晚时间;

class Solution {
    public String maximumTime(String time) {
        byte[] ans = time.getBytes();
        if(ans[0] == '?' && ans[1] == '?' ){
            ans[0] = '2';
            ans[1] = '3';
        }else if(ans[0] == '?'){
            if(ans[1] < '4'){
                ans[0] = '2';
            }else{
                ans[0] = '1';
            }
        }else if(ans[1] == '?'){
            if(ans[0] == '2'){
                ans[1] = '3';
            }else{
                ans[1] = '9';
            }
        }


        if(ans[3] == '?'){
            ans[3] = '5';
        }
        if(ans[4] == '?'){
            ans[4] = '9';
        }



        return new String(ans);

    }
}