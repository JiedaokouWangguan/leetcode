import java.util.Arrays;

public class Question259{
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for(int index = 0;index < nums.length;index++){
            int tmpTarget = target - nums[index];
            int l = index+1;
            int r = nums.length-1;
            while(l < r){
                if(nums[l] + nums[r] < tmpTarget){
                    result += r-l;
                    l += 1;
                }
                else
                    r -= 1;
            }
        }
        return result;
    }
}
