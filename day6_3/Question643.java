public class Question643{
    public double findMaxAverage(int[] nums, int k){
        if(nums.length < k)
            return 0;
        
        double max = 0;
        double tmpResult = 0;
        for(int i = 0;i<k;i++){
            tmpResult += nums[i];
        }
        max = tmpResult;
        for(int i = k;i<nums.length;i++){
            tmpResult = tmpResult - nums[i-k] + nums[i]; 
            if(max < tmpResult)
                max = tmpResult;
        }
        return max/k;
    }
}
