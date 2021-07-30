package P171Excel表列序号;

class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for(byte c : columnTitle.getBytes()){
            ans *= 26;
            ans += c - 'A' + 1;
        }
        return  ans;
    }
}

/*
给定一个Excel表格中的列名称，返回其相应的列序号。
 */
/*
"A"
"AA"
"BA"
"ZZ"
"AAA"

1
27
53
702
703


 */