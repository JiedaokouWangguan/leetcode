import java.util.List;
import java.util.ArrayList;

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
public class Question339{
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for(NestedInteger i : nestedList)
            sum += getSum(i, 1);
        return sum;
    }

    private int getSum(NestedInteger i, int depth){
        if(i.isInteger())
            return i.getInteger() * depth;
        else{
            int sum = 0;
            for(NestedInteger n : i.getList()){
                sum += getSum(n, depth+1);
            }
            return sum;
        }
    }
}

