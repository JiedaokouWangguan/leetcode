public class Question268{
    public int missingNumber(int[] nums){
        int n = nums.length;
        int result = 0;
        for(int i = 0;i<n+1;i++){
            result ^= i;
        }
        for(int i = 0;i<n;i++){
            result ^= nums[i];
        }
        return result;
    }
}
