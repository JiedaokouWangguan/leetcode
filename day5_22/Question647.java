package leetcode.day5_22;

/**
 * Created by Song on 2018/5/22.
 */
public class Question647
{
    public int countSubstrings(String s) {
        int result = 0;
        boolean[][] valid = new boolean[s.length()][s.length()];
        for (int i = 0;i<s.length();i++)
        {
            valid[i][i] = true;
            result+=1;
        }
        for (int i = s.length()-1;i>=0;i--)
        {
            for (int j = i+1;j<s.length();j++)
            {
                if (s.charAt(i) == s.charAt(j))
                {
                    if ((j-i>2 && valid[i+1][j-1]) || j -i <=2)
                    {
                        valid[i][j] = true;
                        result += 1;
                    }
                }
            }
        }
        return result;
    }
}
