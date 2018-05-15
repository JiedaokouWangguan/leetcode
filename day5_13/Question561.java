package leetcode.day5_13;

import java.util.Arrays;

/**
 * Created by Song on 2018/5/13.
 */
public class Question561
{
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0;i<nums.length;i+=2)
        {
            result += Math.min(nums[i], nums[i+1]);
        }
        return result;
    }
}
