package leetcode.day5_20;

/**
 * Created by Song on 2018/5/20.
 */
public class Question696
{
    public int countBinarySubstrings(String s) {
        int preCount = 0;
        int curCount = 1;
        int result = 0;
        for (int i = 1;i<s.length();i++)
        {
            if (s.charAt(i) == s.charAt(i-1))
            {
                curCount++;
            }
            else
            {
                preCount = curCount;
                curCount = 1;
            }
            if (curCount <= preCount)
                result++;
        }
        return result;
    }
}
