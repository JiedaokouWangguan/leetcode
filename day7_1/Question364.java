import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Question364{
    public int depthSumInverse(List<NestedInteger> nestedList) {
        ArrayDeque<NestedInteger> queue = new ArrayDeque<>();
        for(NestedInteger i : nestedList)
            queue.offer(i);
        int prev = 0;
        int result = 0;
        while(queue.size() != 0){
            int sum = 0;
            int len = queue.size();
            for(int j = 0;j< len;j++){
                NestedInteger i = queue.poll();
                if(i.isInteger())
                    sum += i.getInteger();
                else{
                    for(NestedInteger n : i.getList())
                        queue.offer(n);
                }
            }
            prev += sum;
            result += prev;
        }
        return result;
    }
}

class NestedInteger {
    public NestedInteger(){}
    public boolean isInteger(){
        return false;
    }        
    public Integer getInteger(){
        return null;
    }        
    public void setInteger(int value){}
    public void add(NestedInteger ni){}
    public List<NestedInteger> getList(){
        return null;
    }        
} 

