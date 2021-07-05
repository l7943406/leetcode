package P762原子的数量;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    //formula byte数组
    byte[] s;
    public String countOfAtoms(String formula) {
        //提取string 中 byte数组
        s = formula.getBytes();
        //这个map就是总的map
        HashMap<String,Integer> map = f(0,formula.length() - 1);
        //直接给key sort就是字典序
        String[] keys = map.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        //从map中拼接ans
        StringBuilder ans = new StringBuilder();
        for(String key : keys){
            ans.append(key);
            int num = map.get(key);
            if(num > 1){
                ans.append(num);
            }
        }
        return ans.toString();
    }

    /**
    * @param start 开始位置(含)
    * @param end 结束位置(含)
    * @return 当前()内的内容统计的结果
    */
    public HashMap<String,Integer> f(int start,int end){
        //start - end中的原子数量map
        HashMap<String,Integer> map = new HashMap<>();
        //原子起始终止位置
        int left;
        int right;
        //index
        int index = start;
        while (index <= end){
            //如果遇到大写字母，标志一个原子的开始
            if(s[index] <= 'Z' && s[index] >= 'A'){

                //初始化原子字符左右位置
                left = index;
                right = index;
                //index指向下一位
                index ++;
                //从下一位开始找小写字符 运行到end+1代表此范围查找结束啦
                for (int i = index; i <= end + 1; i++) {
                    if(i == end + 1 || s[i] > 'z' || s[i] < 'a'){
                        right = i - 1;
                        index = i;
                        break;
                    }
                }

                //找原子后面的数字 end+1代表结束
                int num = 1;
                if(index <= end && s[index] <= '9' && s[index] >= '0'){
                    num = 0;
                    for (int i = index; i <= end + 1; i++) {
                        if(i == end + 1){
                            index = i;
                            break;
                        }
                        if(s[i] <= '9' && s[i] >= '0'){
                            num *= 10;
                            num += s[i] - '0';
                        }else{
                            index = i;
                            break;
                        }
                    }
                }

                //添加此原子进map
                byte[] nb = new byte[right - left + 1];
                System.arraycopy(s, left, nb, 0, right + 1 - left);
                String key = new String(nb);
                map.put(key,map.getOrDefault(key,0) + num);


            }//遇到左括号，去寻找右括号 然后递归调用去处理（）中内容
            else if(s[index] == '('){
                left = 0;
                right = 0;
                int t = 1;
                left = index;
                //找到匹配的右括号
                for (int i = index + 1; i <= end; i++) {
                    if(s[i] == '('){
                        t++;
                    }else if(s[i] == ')'){
                        t--;
                    }
                    if(t == 0){
                        right = i;
                        index = i + 1;
                        break;
                    }
                }
                //递归解决（）内内容
                HashMap<String,Integer> child = f(left + 1,right - 1);

                //查找()后数字作为()内原子数量的倍数
                int multiple = 1;
                if(index <= end && s[index]<='9' && s[index] >= '0'){
                    multiple = 0;
                    for (int i = index; i <= end + 1; i++) {
                        if(i == end + 1){
                            index = i;
                            break;
                        }
                        if(s[i]<='9' && s[i] >= '0'){
                            multiple *= 10;
                            multiple += s[i] - '0';
                        }else{
                            index = i;
                            break;
                        }
                    }
                }

                //把括号内原子加进当前map
                for(String key : child.keySet()){
                    map.put(key,map.getOrDefault(key,0)+child.get(key) * multiple);
                }

            }
        }
        return map;
    }

}