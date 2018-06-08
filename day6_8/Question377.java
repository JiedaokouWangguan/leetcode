import java.util.Arrays;

public class Question377{
    int[] record;
    public int combinationSum4(int[] nums, int target){
        record = new int[target+1];
        Arrays.fill(record, -1);
        record[0] = 1;
        return dp(nums, target);    
    }

    private int dp(int[] nums, int target){
        if(record[target] != -1)
            return record[target];
        int sum = 0;
        for(int i=0;i<nums.length && target-nums[i]>=0;i++){
            if(target-nums[i] < 0)
                continue;
            sum += dp(nums, target-nums[i]);       
        }
        record[target] = sum;
        return sum;
    }


}
