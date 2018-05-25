public class Question485{
    public int findMaxConsecutiveOnes(int[] nums) {
        int index = 0;
        int maxLength = 0;
        int indexBegin = -1;

        for(;index<nums.length;index++)
        {
            if(nums[index] == 0)
            {
                maxLength = Math.max(maxLength, index - indexBegin - 1);
                indexBegin = index;
            }
        }
        maxLength = Math.max(maxLength, index - indexBegin - 1);
        indexBegin = index;

        return maxLength;
    }

}
