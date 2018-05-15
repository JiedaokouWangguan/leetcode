package leetcode.day5_13;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Song on 2018/5/13.
 */
public class Question771
{
    public static void main(String[] args)
    {
        System.out.println(numJewelsInStones("z", "ZZ"));
    }
    /*

    class Solution {
        public int numJewelsInStones(String J, String S) {
            int[] allChars = new int[52];
            int ctr = 0;
            for(char c: J.toCharArray()) allChars[chartoint(c)] = 1;
            for(char ch:S.toCharArray()) if(allChars[chartoint(ch)]==1) ctr++;
            return ctr;
        }

        int chartoint(char c) {
            if(c<='z'&& c>='a') return c-'a';
            else return 26+c-'A';
        }
    }
    it's slower to use HashSet. Using array can make it faster.
    And I don't have to sort the array.

    */

    public static int numJewelsInStones(String J, String S) {
        if(J == null || S == null || S.length() == 0 || J.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<J.length();i++)
        {
            set.add(J.charAt(i));
        }

        char[] sArray = S.toCharArray();
        Arrays.sort(sArray);

        int result = 0;
        boolean isPreJew = false;
        if (set.contains(S.charAt(0)))
        {
            isPreJew = true;
            result += 1;
        }
        for (int i = 1;i<S.length();i++)
        {
            if(S.charAt(i) == S.charAt(i-1))
            {
                if(isPreJew)
                {
                    result += 1;
                }
            }
            else
            {
                if(set.contains(S.charAt(i)))
                {
                    isPreJew = true;
                    result += 1;
                }
                else
                {
                    isPreJew = false;
                }
            }
        }
        return result;
    }
}
