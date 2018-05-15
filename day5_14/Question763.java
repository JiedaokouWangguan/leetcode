package leetcode.day5_14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Question763
{
    /*
        public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        if (S == null || S.length() == 0)   return ans;
        char[] s = S.toCharArray();
        int n = s.length;
        int[] rightMost = new int[26];
        for (int i = 0; i < n; ++i)     rightMost[s[i]-'a'] = i;
        int prev = -1, max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, rightMost[s[i]-'a']);
            if (i == max) {
                ans.add(i-prev);
                prev = i;
            }
        }
        return ans;
    }
    this solution is much better
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        int[] count = new int[26];
        for (int i = 0;i<S.length();i++)
        {
            count[S.charAt(i) - 'a'] += 1;
        }

        int index = 0;
        for (int i = 0;i<S.length();i++)
        {
            set.add(S.charAt(i));
            count[S.charAt(i) - 'a'] -= 1;
            if (count[S.charAt(i) - 'a'] == 0)
            {
                set.remove(S.charAt(i));
                if (set.size() == 0)
                {
                    result.add(i - index + 1);
                    index = i + 1;
                }
            }
        }
        if (index != S.length())
        {
            result.add(S.length() - 1 - index + 1);
        }
        return result;
    }


}
