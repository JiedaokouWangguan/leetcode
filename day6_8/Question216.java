import java.util.List;
import java.util.ArrayList;

public class Question216{
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpResult, int k, int n, int index){
        if(n < 0 || k < 0)
            return;
        if(n == 0 && k == 0){
            result.add(new ArrayList<Integer>(tmpResult));
            return;
        }

        for(int i= index;i<=9;i++){
            tmpResult.add(i);
            backtrack(result, tmpResult, k-1, n-i, i+1);
            tmpResult.remove(tmpResult.size()-1);
        }
    }
}
