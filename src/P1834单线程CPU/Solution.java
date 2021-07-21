package P1834单线程CPU;



import java.util.*;

class Solution {
    int[][] tasks;
    public int[] getOrder(int[][] tasks) {
        this.tasks = tasks;
        int[] ans = new int[tasks.length];
        int ansIndex = 0;

        int[] indexes = new int[tasks.length];
        int index = 0;
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        sort(indexes);


        SortedSet<Integer> queue = new TreeSet<>((a , b) -> tasks[a][1] != tasks[b][1] ? tasks[a][1] - tasks[b][1] :  a - b );
        long time = 0;


        while (index < indexes.length){
            if(queue.isEmpty() && tasks[indexes[index]][0] > time){
                time = tasks[indexes[index]][0];
            }
            while(index < indexes.length && tasks[indexes[index]][0] <= time){
                queue.add(indexes[index++]);
            }

            //此时保证堆中有任务待执行，取出执行即可

            int now = queue.first();
            queue.remove(queue.first());
            ans[ansIndex++] = now;
            time += tasks[now][1];
        }

        for(int i : queue){
            ans[ansIndex++] = i;
        }

        return ans;
    }
    public void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(less(arr[i],arr[j])){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    public boolean less(int a,int b){
        return tasks[a][0] == tasks[b][0] ? a < b :  tasks[a][0] < tasks[b][0];
    }
}