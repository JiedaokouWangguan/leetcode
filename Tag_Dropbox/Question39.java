import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question39{
    HashMap<String, List<List<Integer>>> map = new HashMap<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return backtrack(candidates, 0, target);
    }

    private List<List<Integer>> backtrack(int[] candidates, int index, int target){
        String key = index + "," + target;
        if(map.containsKey(key)) return map.get(key);
        List<List<Integer>> curResult = new ArrayList<>();
        if(index >= candidates.length) return curResult;

        for(;index < candidates.length;index++){
            if(target == candidates[index]){
                List<Integer> l = new ArrayList<Integer>();
                l.add(candidates[index]);
                curResult.add(l);
            }
            else if(target > candidates[index]){
                List<List<Integer>> tmp = backtrack(candidates, index, target-candidates[index]);
                if(tmp.size() == 0) continue;
                for(List<Integer> list : tmp){
                    List<Integer> l = new ArrayList<Integer>(list);
                    l.add(candidates[index]);
                    curResult.add(l);
                }
            }
        }
        map.put(key, curResult);
        return curResult;
    }   
}
