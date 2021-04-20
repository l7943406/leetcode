package P40z组合总和;


import java.util.*;

class Solution {
    int length;
    int target;
    List<List<Integer>> ans;
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        this.ans = new ArrayList<>();
        this.length = candidates.length;
        this.target = target;
        this.candidates=candidates;

        Arrays.sort(candidates);

        for(int i=0;i<candidates.length;i++){
            if(candidates[i]>target){
                this.length = i;
                break;
            }
        }

        return combinationSum2();

    }
    public List<List<Integer>> combinationSum2() {

        int n=binaryNum(length);
        String s;
        for(int i=1;i<=n;i++){
            s=binary(i);
            int t=0;
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)!='0'){
                    t+=candidates[j];
                    list.add(candidates[j]);
                }
            }
            if(t==target){
                ans.add(list);
            }
        }
        return ans;

    }

    String binary (int n){
        StringBuilder s = new StringBuilder();
        do {
            s.append(n%2);
        }while((n/=2)!=0);
        s=s.reverse();
        int length1 = s.length();
        for(int i=0;i<length-length1;i++){
            s.append(0);
        }
        return String.valueOf(s);
    }
    int binaryNum(int n){
        int ans=0;
        for(int i=0;i<n;i++){
            ans += Math.pow(2,i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr ={10,1,2,7,6,1,5};
        List<List<Integer>> list = new Solution().combinationSum2(arr,8);
        for(List<Integer> list1 : list){
            for(Integer t:list1){
                System.out.print(t);
            }
            System.out.println();
        }
    }
}