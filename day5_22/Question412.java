package leetcode.day5_22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Song on 2018/5/22.
 */
public class Question412
{
    public List<String> fizzBuzz(int n)
    {
        List<String> result = new ArrayList<>();
        // 3-Fizz, 5-Buzz
        int count3 = 1;
        int count5 = 1;
        for (int i = 1;i<=n;i++)
        {
            if (count3 == 3 && count5 == 5)
            {
                result.add("FizzBuzz");
                count3 = 0;
                count5 = 0;
            }
            else if(count3 == 3)
            {
                result.add("Fizz");
                count3 = 0;
            }
            else if (count5 == 5)
            {
                result.add("Buzz");
                count5 = 0;
            }
            else
                result.add(String.valueOf(i));

            count3++;
            count5++;
        }
        return result;
    }
}
