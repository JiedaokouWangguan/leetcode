package leetcode.day5_22;

/**
 * Created by Song on 2018/5/22.
 */
public class Question526
{
    int count = 0;
    public int countArrangement(int N)
    {
        backtrack(N, 1, new int[N]);
        return count;
    }

    private void backtrack(int N, int index, int[] tmp)
    {
        if (index > N)
            return;

        for (int i = 0;i<tmp.length;i++)
        {
            if (tmp[i] == 0 && (index % i == 0|| i % index == 0))
            {
                count += 1;
                tmp[i] = index;
                backtrack(N, index+1, tmp);
                tmp[i] = 0;
            }
        }
    }


}
