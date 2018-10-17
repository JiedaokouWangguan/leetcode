import java.util.List;
import java.util.ArrayList;

public class Question254{

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, 2);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpResult, int n, int factor){
        if(n <= 1){
            if(tmpResult.size() > 1)
                result.add(new ArrayList<>(tmpResult));
            return;
        }
        for(int i = factor;i<=n;i++){
            if(n % i != 0) continue;
            tmpResult.add(i);
            backtrack(result, tmpResult, n/i, i);
            tmpResult.remove(tmpResult.size()-1);
        }
    }
}
