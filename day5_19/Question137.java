package leetcode;

/**
 * Created by Song on 2018/5/19.
 */
public class Question137
{
    // awesome
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0;i<32;i++)
        {
            int count = 0;
            for (int j = 0;j<nums.length;j++)
            {
                if (((nums[j] >> i) & 1) == 1)
                {
                    count ++;
                    count %= 3;
                }
            }
            if(count == 1)
                result |= (1 << i);
        }
        return result;
    }

}
