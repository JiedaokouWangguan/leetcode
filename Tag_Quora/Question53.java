public class Question53{
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int sum = 0;
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        }             
        int max = dp[0];
        for(int i : dp) max = Math.max(max, i); 
        return max;                                                                                                        
    }      

}
