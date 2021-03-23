package P341扁平化嵌套列表迭代器;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

    // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    List<Integer> ans;
    Iterator<Integer> it;
    public NestedIterator(List<NestedInteger> nestedList) {
        ans = new LinkedList<>();
        init(nestedList);
        it = ans.iterator();
    }
    public void init(List<NestedInteger> nestedList){
        for(NestedInteger nested : nestedList){
            if(nested.isInteger()){
                ans.add(nested.getInteger());
            }else{
                init(nested.getList());
            }
        }
    }

    @Override
    public Integer next() {
       return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}
