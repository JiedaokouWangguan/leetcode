public class Question689{
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] dp1 = new int[n-k+1];
        int[] dp2 = new int[n-2*k+1];
        int[] dp3 = new int[n-3*k+1];
        int[] sum = new int[n-k+1];

        for(int i = 0;i<k;i++) sum[0] += nums[i];
        for(int i = 1;i<sum.length;i++) sum[i] = sum[i-1]-nums[i-1]+nums[i+k-1];

        dp1[n-k] = n-k;
        for(int i = n-k-1;i>=0;i--) {
            dp1[i] = sum[i] > sum[dp1[i+1]]?i:dp1[i+1];
        }

        dp2[n-2*k] = n-2*k;
        for(int i = n-2*k-1;i>=0;i--) dp2[i] = sum[i] + sum[dp1[i+k]] > sum[dp2[i+1]] + sum[dp1[dp2[i+1]+k]]?i:dp2[i+1];

        dp3[n-3*k] = n-3*k;
        for(int i = n-3*k-1;i>=0;i--) {
            int a = sum[i] + sum[dp2[i+k]] + sum[dp1[dp2[i+k]+k]];
            int b = sum[dp3[i+1]] + sum[dp2[dp3[i+1]+k]] + sum[dp1[dp2[dp3[i+1]+k]+k]];
            dp3[i] = sum[i] + sum[dp2[i+k]] + sum[dp1[dp2[i+k]+k]] > sum[dp3[i+1]] + sum[dp2[dp3[i+1]+k]] + sum[dp1[dp2[dp3[i+1]+k]+k]]?i:dp3[i+1];
        }

        int[] result = new int[3];
        result[0] = dp3[0];
        result[1] = dp2[result[0]+k];
        result[2] = dp1[result[1]+k];
        return result;
    }
}
