package leetcode.day5_22;

/**
 * Created by Song on 2018/5/22.
 */
public class Question413
{
    public int numberOfArithmeticSlices(int[] A)
    {
        if(A == null || A.length <= 2)
            return 0;
        int result = 0;
        int[] diff = new int[A.length-1];
        for (int i = 0;i<A.length-1;i++)
        {
            diff[i] = A[i] - A[i+1];
        }

        int indexBegin = 0;
        int indexEnd = 1;
        while (indexBegin < diff.length && indexEnd < diff.length)
        {
            if (diff[indexBegin] != diff[indexEnd])
            {
                indexBegin = indexEnd;
                indexEnd = indexBegin + 1;
            }
            else
            {
                result += indexEnd - indexBegin;
                indexEnd += 1;
            }
        }
        return result;
    }
}
