import java.util.List;
import java.util.ArrayList;

// EZ DP, Time complexity is O(NM) where n is the length of string i and m is the length of string j.
// Space complexity is also O(NM)
// 这个题是一个很简单的dp，时间空间复杂度都是Omn，n是行，m是列

public class Mianjing8{
    public List<String> longestContinuousCommon(List<List<String>> data, int i, int j){
        return helper(data.get(i), data.get(j));
    }

    private List<String> helper(List<String> list1, List<String> list2){
        int n = list1.size();
        int m = list2.size();
        int[][] dp = new int[n+1][m+1];

        int max = 0;
        int indexI = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(list1.get(i-1).equals(list2.get(j-1))) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = 0;
                if(dp[i][j] > max){
                    max = dp[i][j];
                    indexI = i;
                }
            }
        }

        List<String> result = new ArrayList<>();
        for(int i = indexI - max;i<indexI;i++){
            result.add(list1.get(i));
        }
        return result;
    } 
}
