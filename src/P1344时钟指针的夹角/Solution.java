package P1344时钟指针的夹角;

class Solution {
    public double angleClock(int hour, int minutes) {
        double h = minutes / 2.0 + (hour % 12) * 30;
        double m = minutes * 6;
        double ans = Math.abs(h - m);
        return Math.min(ans,360 - ans);
    }

}