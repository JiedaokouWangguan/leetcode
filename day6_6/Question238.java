public class Question238{
    public int[] productExceptSelf(int[] nums){
        
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1;i<result.length;i++){
            result[i] = result[i-1] * nums[i-1];
        }
        int res = 1;
        for(int i = nums.length-1;i>=0;i--){
            result[i] *= res;
            res *= nums[i];
        }
        return result;
    }
}
