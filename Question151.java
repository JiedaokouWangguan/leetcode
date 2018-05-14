package leetcode;

/**
 * Created by Song on 2018/5/13.
 */
public class Question151
{
    public String reverseWords(String s)
    {
        String[] ss = s.trim().split("((\\s)+)");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length-1;i>=0;i--)
        {
            sb.append(ss[i]);
            sb.append(" ");
        }
        String result = sb.toString();
        return result.substring(0, result.length()-1);
    }
}
