package leetcode.day5_20;

/**
 * Created by Song on 2018/5/20.
 */
public class Question338
{
    public int[] countBits(int num)
    {
        int[] result = new int[num + 1];
        for(int i = 1;i<=num;i++)
        {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
    /*
    awesome solution
     */
}
