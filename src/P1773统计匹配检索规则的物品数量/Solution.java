package P1773统计匹配检索规则的物品数量;

import java.util.List;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int type = 0;
        switch (ruleKey){
            case "type": type = 0;break;
            case "color": type = 1;break;
            case "name": type = 2;break;
        }
        int finalType = type;
        return (int)items.stream().filter((list)-> list.get(finalType).equals(ruleValue)).count();
    }
}