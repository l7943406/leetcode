package P605种花问题;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] != 1){
                if(i == 0){
                    if(flowerbed.length == 1 ){
                        num ++;
                    }else{
                        if(flowerbed[1] == 0){
                            flowerbed[i] = 1;
                            num++;
                        }
                    }
                }else if(i == flowerbed.length-1){
                    if(flowerbed[i - 1] == 0){
                        flowerbed[i] = 1;
                        num++;
                    }
                }else{
                    if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                        flowerbed[i] = 1;
                        num++;
                    }
                }
            }
        }
        return num >= n;
    }
}