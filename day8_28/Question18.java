package leetcode.day8_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Song on 2018/9/2.
 */
public class Question18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length-3){
            int j = i + 1;
            while (j < nums.length-2){
                helper(result, nums, i, j, target - nums[i] - nums[j]);
                j += 1;
                while (j < nums.length-2 && nums[j] == nums[j-1]) j += 1;
            }
            i += 1;
            while (i < nums.length-3 && nums[i] == nums[i-1]) i += 1;
        }
        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, int i, int j, int target){
        int begin = j+1;
        int end = nums.length-1;
        while (begin < end){
            int tmpSum = nums[begin] + nums[end];
            if (tmpSum == target){
                List<Integer> res = new ArrayList<>(4);
                res.add(nums[i]);
                res.add(nums[j]);
                res.add(nums[begin]);
                res.add(nums[end]);
                result.add(res);
                begin += 1;
                end -= 1;
                while (begin < end && nums[begin] == nums[begin-1]) begin += 1;
                while (begin < end && nums[end] == nums[end+1]) end -= 1;
            }
            else if (tmpSum > target) end -= 1;
            else begin += 1;
        }
    }
}
