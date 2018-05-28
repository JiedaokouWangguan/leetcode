import java.util.Arrays;

public class Question453{
    public int minMoves(int[] nums){
        if(nums == null || nums.length == 1)
            return 0;
        Arrays.sort(nums);
        int min = nums[0];
        int result = 0;
        for(int i = 1;i<nums.length;i++){
            result += nums[i] - min;
        }
        return result;
    }
}
