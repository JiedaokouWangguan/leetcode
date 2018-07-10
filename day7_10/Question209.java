public class Question209{
    public int minSubArrayLen(int s, int[] nums) {  
        if(nums == null || nums.length == 0) return 0;
        int left = 0;              
        int right = 0;             
        int curSum = 0;            
        int len = Integer.MAX_VALUE;                
        while(right < nums.length){                                                                                         
            while(curSum < s && right < nums.length)
                curSum += nums[right++];            
            while(curSum >= s){    
                len = Math.min(len, right - left);
                curSum -= nums[left++];             
            }                      
        }                          
        return len == Integer.MAX_VALUE?0:len;                
    }
}
