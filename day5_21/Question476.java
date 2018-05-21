package leetcode.day5_21;

/**
 * Created by Song on 2018/5/21.
 */
public class Question476
{
    public int findComplement(int num)
    {
        int result = 0;
        boolean tag = false;
        for (int i = 30;i>=0;i--)
        {
            if (((num >> i) & 1) == 1)
            {
                if (!tag)
                    tag = true;

                num &= ~(1 << i);
            }
            else
            {
                if (tag)
                {
                    num |= (1 << i);
                }
            }
        }
        return num;
    }
}
