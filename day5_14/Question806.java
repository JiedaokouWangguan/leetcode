package leetcode.day5_14;

public class Question806
{
    public int[] numberOfLines(int[] widths, String S)
    {
        int[] result = new int[2];
        int numLines = 1;
        int curLength = 0;
        int lineLength = 100;

        char[] cArray = S.toCharArray();

        for (int i = 0;i<cArray.length;i++)
        {
            int tmpLength = widths[cArray[i] - 'a'];
            if (curLength + tmpLength > lineLength)
            {
                numLines += 1;
                curLength = tmpLength;
            }
            else
            {
                curLength += tmpLength;
            }
        }

        result[0] = numLines;
        result[1] = curLength;
        return result;
    }
}
