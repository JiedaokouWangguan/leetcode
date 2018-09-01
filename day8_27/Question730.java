package leetcode.day8_27;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Song on 2018/9/1.
 */
public class Question730 {
    int mod = 1000000007;
    public int countPalindromicSubsequences(String S) {
        List<TreeSet<Integer>> index = new ArrayList<>();
        for(int i = 0;i<26;i++) index.add(new TreeSet<Integer>());
        for(int i = 0;i<S.length();i++){
            int in = S.charAt(i) - 'a';
            index.get(in).add(i);
        }
        int len = S.length();
        Integer[][] dp = new Integer[len+1][len+1];
        helper(dp, 0, len, S, index);
        return dp[0][len];
    }

    private int helper(Integer[][] dp, int begin, int end, String s, List<TreeSet<Integer>> index){
        if(begin >= end) return 0;
        if(dp[begin][end] != null) return dp[begin][end];
        long res = 0;
        for (int i = 0;i<26;i++){
            Integer newBegin = index.get(i).ceiling(begin);
            Integer newEnd = index.get(i).lower(end);
            if (newBegin == null || newEnd == null || newBegin > newEnd) continue;
            res += 1;
            if (!newBegin.equals(newEnd)) res += 1;
            res += helper(dp, newBegin+1, newEnd, s, index);
        }
        dp[begin][end] = (int)(res%mod);
        return dp[begin][end];
    }
}
