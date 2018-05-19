package leetcode.day5_19;

/**
 * Created by Song on 2018/5/19.
 */
public class Question516
{
    public int longestPalindromeSubseq(String s) {
        int[][] result = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0;i--)
        {
            result[i][i] = 1;
            for (int j = i+1;j < s.length();j++)
            {
                if (s.charAt(i) == s.charAt(j))
                {
                    result[i][j] = result[i+1][j-1] + 2;
                }
                else
                {
                    result[i][j] = Math.max(result[i+1][j], result[i][j-1]);
                }
            }
        }
        return result[0][s.length()-1];
    }
}
