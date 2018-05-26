public class Question674{
    public int findLengthOfLCIS(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;
        int result = 1;
        int maxValue = 0;
        for(int i = 1;i<nums.length;i++)
        {
            if(nums[i] > nums[i-1])
            {
                result += 1;
            }
            else
            {
                maxValue = Math.max(maxValue, result);
                result = 1;
            }
        }
        maxValue = Math.max(maxValue, result);
        return maxValue;
    }
}
