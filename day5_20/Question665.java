package leetcode.day5_20;

/**
 * Created by Song on 2018/5/19.
 */
public class Question665
{
    public boolean checkPossibility(int[] nums)
    {
        int tmpMax = Integer.MIN_VALUE;
        boolean tag = false;
        for (int i = 0;i<nums.length-1;i++)
        {
            if (nums[i] > nums[i+1])
            {
                if (tag)
                    return false;
                else
                {
                    if(nums[i+1] >= tmpMax)
                    {
                        nums[i] = nums[i+1];
                    }
                    else
                    {
                        nums[i+1] = nums[i];
                    }
                    tmpMax = nums[i];
                    tag = true;
                }
            }
            else
            {
                tmpMax = nums[i];
            }
        }
        return true;
    }
}
