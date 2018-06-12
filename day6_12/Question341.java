import java.util.List;
import java.util.Iterator;
import java.util.ArrayDeque;

class NestedInteger{
    public Integer getInteger(){
        return 0;
    }
    public boolean isInteger(){
        return false;
    }
    public List<NestedInteger> getList(){
        return null;
    }
}

class NestedIterator implements Iterator<Integer>{
    private ArrayDeque<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList){
        stack = new ArrayDeque<>();
        for(int i = nestedList.size() - 1; i >= 0;i--){
            stack.push(nestedList.get(i));
        }          
    }   
        
    @Override      
    public Integer next(){
        return stack.pop().getInteger();
    }           
    @Override      
    public boolean hasNext(){
        while(stack.size() != 0){
            NestedInteger tmp = stack.peek();
            if(tmp.isInteger()){
                return true;
            }
            else{
                stack.pop();
                List<NestedInteger> tmpList = tmp.getList();
                for(int i = tmpList.size()-1;i>=0;i--){
                    stack.push(tmpList.get(i));
                }  
            }
        }  
        return false;
    }
}
