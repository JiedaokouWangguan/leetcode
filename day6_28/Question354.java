import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Question354{
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                if(i1[0] == i2[0])
                    return i1[1] - i2[1];
                else
                    return i1[0] - i2[0];
            }
        });
        int max = 1;
        int[] dp = new int[envelopes.length];
        dp[envelopes.length-1] = 1;
        for(int i = envelopes.length-2;i>=0;i--){
            int tmpMax = 1;
            for(int j = i+1;j<envelopes.length;j++){
                if(dp[j] + 1 > tmpMax && envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1])
                    tmpMax = dp[j] + 1;
            }
            dp[i] = tmpMax;
            max = Math.max(max, tmpMax);
        }
        return max;
    }
}
