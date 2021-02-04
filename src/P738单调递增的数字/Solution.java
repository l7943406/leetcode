package P738单调递增的数字;


class Solution {
    public int monotoneIncreasingDigits(int N) {
        if(N < 10){
            return N;
        }

        //结果
        int ans = 0;

        //求N长度
        int n = N;
        byte length= 0;
        while(n!=0){
            n/=10;
            length++;
        }

        //把数字放入数组
        n = N;
        byte[] arr = new byte[length];
        for (int i = length - 1 ; i > -1; i--) {
            arr[i] = (byte)(n % 10);
            n  /= 10;
        }

        for (int i = 1; i < length; i++) {
            if(arr[i] < arr[i-1]){
                n = i;
                break;
            }
        }
        if(n == 0){
            return N;
        }

        arr[ n-1 ] -- ;
        int flag = 0;
        for (int i = n - 1; i > 0 ; i--) {
            if(arr[i] - arr[i-1] < 0){
                arr[i-1]--;
            }else{
                flag = i;
                break;
            }
        }
        flag ++;

        for (int i = 0; i < flag; i++) {
            ans *= 10;
            ans += arr[i];
        }
        for (int i = flag; i < arr.length; i++) {
            ans *= 10;
            ans += 9;
        }
        return ans;
    }
}