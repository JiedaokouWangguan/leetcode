import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Question491{
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        backtrack(set, new ArrayList<Integer>(), 0, nums);
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    private void backtrack(HashSet<List<Integer>> set, List<Integer> tmpResult, int index, int[] nums){
        if(tmpResult.size() > 1)
            set.add(new ArrayList<>(tmpResult));
        for(int i = index;i<nums.length;i++){
            if(tmpResult.size() == 0 || nums[i] >= tmpResult.get(tmpResult.size()-1)){
                tmpResult.add(nums[i]);
                backtrack(set, tmpResult, i+1, nums);
                tmpResult.remove(tmpResult.size()-1);
            }
        }
    }
}
