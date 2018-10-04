import java.util.List;
import java.util.ArrayList;

public class Question77{
    // 6.15 - 6.21, 7mins
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), n, k, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpResult, int n, int k, int index){
        if(tmpResult.size() == k){
            result.add(new ArrayList<>(tmpResult));
            return;
        }
        for(int i = index;i<=n;i++){
            tmpResult.add(i);
            backtrack(result, tmpResult, n, k, i+1);
            tmpResult.remove(tmpResult.size()-1);
        }
    }
}
