public class Question300{
    
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for(int end = 1;end < nums.length;end++){
            int res = 1;
            for(int start = 0;start < end;start++){
                if(nums[start] > nums[end]) continue;
                res = Math.max(res, 1 + dp[start]);
            }
            dp[end] = res;
            result = Math.max(res, result);
        }
        return result;
    }
}
