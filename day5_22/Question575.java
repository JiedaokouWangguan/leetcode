package leetcode.day5_22;

import java.util.Arrays;

/**
 * Created by Song on 2018/5/22.
 */
public class Question575
{
    public int distributeCandies(int[] candies)
    {
        int total = candies.length;
        int chosen = 0;
        Arrays.sort(candies);

        for (int i = 0;i<candies.length-1;i++)
        {
            if (candies[i] != candies[i+1])
            {
                chosen += 1;
                if (chosen == total/2)
                    return chosen;
            }
        }
        chosen += 1;
        return chosen;
    }
}
