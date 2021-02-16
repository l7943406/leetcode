package P657机器人能否返回原点;

class Solution {
    public boolean judgeCircle(String moves) {

        int R=0,L=0,U=0,D=0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if(c == 'R'){
                R++;
            }else if(c == 'L'){
                L++;
            }else if(c == 'U'){
                U++;
            }else if(c == 'D'){
                D++;
            }
        }


        return R == L && U == D;
    }
}