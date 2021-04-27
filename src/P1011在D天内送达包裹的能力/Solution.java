package P1011在D天内送达包裹的能力;


class Solution {
    int[] weights;
    int D;
    public int shipWithinDays(int[] weights, int D) {
        this.weights = weights;
        this.D = D;

        int sum = 0;
        int max = 0;
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max,weight);
        }
        int l = Math.max(max,sum/D);
        int cut;
        if(weights.length % D == 0){
            cut = weights.length / D;
        }else{
            cut = weights.length / D + 1;
        }
        int r = Math.min(max * cut, sum);
        while (l <= r){
            int mid = (l + r) / 2;
            if(can(mid)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    public boolean can(int step){
        int count = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > step) {
                sum = weight;
                count++;
                if (count > D) {
                    return false;
                }
            } else {
                sum += weight;
            }
        }
        return count <= D;
    }
}