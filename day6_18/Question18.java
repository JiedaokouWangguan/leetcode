import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Question18{
    public List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums, 0, target);
        return result;
    }

    private void backtrack(List<List<Integer>> result , List<Integer> tmpResult, int[] nums, int index, int target){
        if(tmpResult.size() > 4)
            return;
        if(tmpResult.size() == 4 && target == 0){
            result.add(new ArrayList<Integer>(tmpResult));
            return;
        }

        for(int i = index;i<nums.length;i++){
            if(i!= index && nums[i] == nums[i-1])
                continue;
            tmpResult.add(nums[i]);
            backtrack(result, tmpResult, nums, i+1, target-nums[i]);
            tmpResult.remove(tmpResult.size()-1);
        }
    }
}
