import java.util.List;
import java.util.ArrayList;

public class Question39Fuck{
    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpResult, int[] nums, int target, int start){
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(tmpResult));
            return;
        }

        for(int i = start;i<nums.length;i++){
            tmpResult.add(nums[i]);
            backtrack(result, tmpResult, nums, target-nums[i], i);
            tmpResult.remove(tmpResult.size()-1);
        }
    }
}
