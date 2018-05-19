package leetcode;

/**
 * Created by Song on 2018/5/19.
 */
public class Question136
{
    public int singleNumber(int[] nums)
    {
        int result = 0;
        for(int i = 0;i<nums.length;i++)
        {
            result = result ^ nums[i];
        }
        return result;
    }
}
