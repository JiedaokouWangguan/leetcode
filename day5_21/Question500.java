package leetcode.day5_21;

import java.util.*;

/**
 * Created by Song on 2018/5/21.
 */
public class Question500
{
    public String[] findWords(String[] words)
    {
        List<String> list = new ArrayList<>();
        for (String word : words)
        {
            if (valid(word))
            {
                list.add(word);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0;i<list.size();i++)
        {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public boolean valid(String word)
    {
        Set<Character> set1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> set3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        boolean[] flag = new boolean[3];
        Arrays.fill(flag, true);
        for (char c : word.toLowerCase().toCharArray())
        {
            if(!set1.contains(c))
            {
                flag[0] = false;
            }
            if(!set2.contains(c))
            {
                flag[1] = false;
            }
            if (!set3.contains(c))
            {
                flag[2] = false;
            }
        }
        return flag[0] || flag[1] || flag[2];
    }
}
