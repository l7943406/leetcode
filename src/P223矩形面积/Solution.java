package P223矩形面积;

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int ans = (ax2 - ax1) * (ay2 - ay1) + (by2 - by1) * (bx2 - bx1);
        if(ax1 > bx1){
            ans -= intersection(bx1,by1,bx2,by2,ax1,ay1,ax2,ay2);
        }else{
            ans -= intersection(ax1,ay1,ax2,ay2,bx1,by1,bx2,by2);
        }
        return ans;
    }
    private int intersection(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2){
        if(bx1 >= ax2){
            return 0;
        }else{
            if(by1 >= ay2){
                return 0;
            }else{
                if(by2 <= ay1){
                    return 0;
                }else{
                    int up = Math.min(by2, ay2);
                    int down = Math.max(ay1, by1);
                    int l = Math.max(ax1, bx1);
                    int r = Math.min(ax2, bx2);
                    return (up - down) * (r - l);
                }
            }
        }
    }
}