package leetcode.day5_21;

/**
 * Created by Song on 2018/5/21.
 */
public class Question520
{
    public boolean detectCapitalUse(String word) {
        if (Character.isUpperCase(word.charAt(0)))
        {
            if (word.length() == 1)
                return true;
            if (Character.isUpperCase(word.charAt(1)))
            {
                for (int i = 2;i<word.length();i++)
                    if (Character.isLowerCase(word.charAt(i)))
                        return false;
                return true;
            }
            else
            {
                for (int i = 2;i<word.length();i++)
                    if (Character.isUpperCase(word.charAt(i)))
                        return false;
                return true;
            }
        }
        else
        {
            for (int i = 1;i<word.length();i++)
                if (Character.isUpperCase(word.charAt(i)))
                    return false;
            return true;
        }
    }
}
