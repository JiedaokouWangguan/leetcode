package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Song on 2018/5/13.
 */
public class Question728
{
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left;i<=right;i++)
        {
            String num = String.valueOf(i);
            boolean isValid = true;
            for (int j = 0;j<num.length();j++)
            {
                if(num.charAt(j) == '0' || i % (num.charAt(j) - '0') != 0)
                {
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                list.add(i);
        }
        return list;
    }
}
