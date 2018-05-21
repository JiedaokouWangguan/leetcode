package leetcode.day5_21;

import java.util.Scanner;

/**
 * Created by Song on 2018/5/21.
 */
public class Question557
{
    public String reverseWords(String s)
    {
        if (s.length() == 0 || s.length() == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(s);
        while (scanner.hasNext())
        {
            String tmp = scanner.next();
            for (int j = tmp.length()-1;j >=0;j--)
            {
                sb.append(tmp.charAt(j));
            }
            sb.append(" ");
        }
        String result = sb.toString();
        return result.substring(0, result.length()-1);
    }
}
