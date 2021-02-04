package P1063设计停车系统;

class ParkingSystem {
    private int[] arr;
    public ParkingSystem(int big, int medium, int small) {
        arr = new int[3];
        arr[0] = big;
        arr[1] = medium;
        arr[2] = small;
    }

    public boolean addCar(int carType) {
       if(arr[carType-1] <= 0){
           return false;
       }else{
           arr[carType - 1] -- ;
           return true;
       }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */