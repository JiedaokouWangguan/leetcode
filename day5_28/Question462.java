import java.util.Arrays;

public class Question462{
    public int minMoves2(int[] nums){
        Arrays.sort(nums);
        int begin = 0;
        int end = nums.length-1;
        int result = 0;
        while(begin < end){
            result += nums[end] - nums[begin];
            end -= 1;
            begin += 1;
        }
        return result;
    }
}
