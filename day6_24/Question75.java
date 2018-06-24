import java.util.ArrayDeque;

public class Question75{
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1)
            return 0;
        int result = 0;
        int left = 0;
        int right = 0;
        int newRight = 0;
        while(true){
            result += 1;
            for(int i = left;i<=right;i++){
                newRight = Math.max(newRight, i + nums[i]);
            }
            if(newRight >= nums.length-1)
                return result;
            left = right + 1;
            right = newRight;
        }
    }
}
