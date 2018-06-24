import java.util.ArrayDeque;

public class Question456{
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;
        int[] curMin = new int[nums.length];
        curMin[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            curMin[i] = Math.min(curMin[i-1], nums[i]);
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int j = nums.length-1;j>= 0;j--){
            while(stack.size() != 0 && curMin[j] >= stack.peek()){
                stack.pop();
            }
            if(stack.size() != 0 && nums[j] > stack.peek())
                return true;
            stack.push(nums[j]);
        }
        return false;
    }
}
