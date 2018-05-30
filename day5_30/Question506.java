import java.util.Arrays;

public class Question506{
    public String[] findRelativeRanks(int[] nums){
        int n = nums.length;
        int[][] rank = new int[n][n];
        for(int i = 0;i<n;i++){
            rank[i][0] = nums[i];
            rank[i][1] = i;
        }
        Arrays.sort(rank, (a, b)->b[0] - a[0]);

        String[] result = new String[n];
        for(int i = 0;i<n;i++){
            if(i == 0){
                result[rank[i][1]] = "Gold Medal";
            }
            else if(i == 1){
                result[rank[i][1]] = "Silver Medal";
            }
            else if(i == 2){
                result[rank[i][1]] = "Bronze Medal";
            }
            else{
                result[rank[i][1]] = "" + (i + 1);
            }
        }
        return result;
    }
}
