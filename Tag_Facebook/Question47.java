import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Question47{
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpResult, int[] nums){
        if(tmpResult.size() == nums.length){
            result.add(new ArrayList<>(tmpResult));
            return;
        }   
        for(int i = 0;i<nums.length;i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            if(nums[i] == Integer.MIN_VALUE) continue;
            int tmp = nums[i];
            nums[i] = Integer.MIN_VALUE;
            tmpResult.add(tmp);
            backtrack(result, tmpResult, nums);
            tmpResult.remove(tmpResult.size()-1);
            nums[i] = tmp;
        }
    }
}
