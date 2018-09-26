import java.util.Comparator;
import java.util.Arrays;

public class Question354{
    // 6.15-6.25
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[0]*i1[1] - i2[0]*i2[1];
            }
        });

        int max = 1;
        int n = envelopes.length;
        int[] dp = new int[n];
        for(int i = 0;i<n;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
