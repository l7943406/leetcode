package P15三数之和;

import java.util.*;

class SolutionP15 {
    public Map<String,String> book;
    public List<List<Integer>> ans;
    public int[] nums;
    public int max;
    public List<List<Integer>> threeSum(int[] nums) {
        this.ans = new ArrayList<>();
        this.book=new HashMap<>();
        this.nums=nums;

        if(nums==null){
            return ans;
        }
        else if(nums.length<3){
            return ans;
        }
        Arrays.sort(nums);

        for (int i = 1; i < nums.length-1; i++) {
            solve(i);
        }
        return ans;
    }
    public void solve(int t){
        max= nums.length-1;
        int king;
        int left;
        int right;
        for (int i = 0; i < t; i++) {
            left=nums[i];
            king=nums[t];
            right= -left - king;
            if(find(right,t)){
                if(book.containsKey(left+"&"+king+"&"+right)){
                    continue;
                }else{
                    book.put(left+"&"+king+"&"+right,left+"&"+king+"&"+right);
                    List<Integer> three=new ArrayList<>();
                    three.add(left);
                    three.add(king);
                    three.add(right);
                    ans.add(three);
                }
            }
        }
    }
    public boolean find(int right,int t){
        for (int i = max; i >t ; i--) {
            if(right==nums[i]){
                max=i;
                return true;
            }else if(right>nums[i]){
                max=i;
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] s={-1,0,1,2,-1,-4};
        Iterator<List<Integer>> it=new SolutionP15().threeSum(s).iterator();
        while(it.hasNext()){
            List three=it.next();
            System.out.println(three.get(0));
            System.out.println(three.get(1));
            System.out.println(three.get(2));
            System.out.println("-----------------------------------");
        }
    }
}
