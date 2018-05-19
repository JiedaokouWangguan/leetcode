package leetcode;

/**
 * Created by Song on 2018/5/19.
 */
public class Question260 {
    public int[] singleNumber(int[] nums)
    {
        int bit = 0;
        for (int i = 0;i<nums.length;i++)
        {
            bit ^= nums[i];
        }

        bit &= -bit;
        int[] result = new int[2];
        int first = 0;
        int second = 0;
        for (int i = 0;i<nums.length;i++)
        {
            if ((nums[i] & bit) == 0)
            {
                first ^= nums[i];
            }
            else
            {
                second ^= nums[i];
            }
        }
        result[0] = first;
        result[1] = second;
        return result;
    }
}
