package leetcode.day5_24;

import java.util.ArrayList;

/**
 * Created by Song on 2018/5/24.
 */
public class Question682
{
    public int calPoints(String[] ops)
    {
        ArrayList<Integer> records = new ArrayList<>();
        int result = 0;
        for (int i = 0;i<ops.length;i++)
        {
            String s = ops[i];
            if (s.equals("+"))
            {
                int last = records.get(records.size()-1);
                int llast = records.get(records.size()-2);
                records.add(last+llast);
                result += last + llast;
            }
            else if (s.equals("D"))
            {
                int last = records.get(records.size()-1);
                records.add(last * 2);
                result += last * 2;
            }
            else if (s.equals("C"))
            {
                result -= records.get(records.size()-1);
                records.remove(records.size()-1);
            }
            else
            {
                int points = Integer.parseInt(s);
                result += points;
                records.add(points);
            }
        }
        return result;
    }
}
