import java.util.List;
import java.util.Iterator;
import java.util.ArrayDeque;

class NestedIterator implements Iterator<Integer> {
    // 9.15 - Infinity, 很久 
    
    ArrayDeque<Iterator<NestedInteger>> stack = new ArrayDeque<>();
    NestedInteger fuck = null;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return fuck == null?null:fuck.getInteger();
    }

    @Override
    public boolean hasNext() {
        while(stack.size() != 0){
            if(!stack.peek().hasNext()) stack.pop();
            else if((fuck = stack.peek().next()).isInteger()) return true;
            else{
                stack.push(fuck.getList().iterator());
            }
        }
        return false;
    }
}

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
