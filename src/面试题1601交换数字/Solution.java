package 面试题1601交换数字;



class Solution {
    public int[] swapNumbers(int[] numbers) {
        if(numbers[0] >= 0 && numbers[1] >= 0 || (numbers[0] <= 0 && numbers[1] <= 0)){
            numbers[0] = numbers[0] - numbers[1];
            numbers[1] = numbers[0] + numbers[1];
            numbers[0] = numbers[1] - numbers[0];
        }else{
            numbers[0] = numbers[0] + numbers[1];
            numbers[1] = numbers[0] - numbers[1];
            numbers[0] = numbers[0] - numbers[1];
        }
        return numbers;
    }
}